package main;

import interfaces.*;
import objects.Account;
import objects.Transaction;
import objects.dbConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountManager implements Structure<Account> {
	private int uid;
	private dbConnector db;
	private TransactionManager tm;

	public AccountManager(int uid) {
		this.uid = uid;
		this.db = new dbConnector();
		this.tm = new TransactionManager(uid);
	}

	@Override
	public void show(int aid) throws SQLException {
		String stmt = "SELECT * FROM accounts WHERE aid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, aid);
		// TODO
		db.runStmt(ps);
	}

	@Override
	public void createNew(Account account) throws SQLException {
		String stmt = "INSERT INTO accounts (atitle, adescription, aamount, uid) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, account);
		ps.setInt(4, uid);
		db.runStmt(ps);
	}

	@Override
	public void mod(Account accountOld, Account accountNew) throws SQLException {
		mod(accountOld.getAid(), accountNew);
	}

	@Override
	public void mod(int aidOld, Account account) throws SQLException {
		String stmt = "UPDATE accounts SET atitle = ?, adescription = ?, aamount = ? WHERE aid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, account);
		ps.setInt(4, aidOld);
		db.runStmt(ps);
	}

	@Override
	public void delete(Account account) throws SQLException {
		delete(account.getAid());
	}

	@Override
	public void delete(int aid) throws SQLException {
		String stmt = "DELETE FROM transactions WHERE tid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, aid);
	}

	public void transfer(Account accountFrom, Account accountTo, float value, Date date) throws SQLException {
		String description = "Transfer from" + accountFrom.getAdescription() + "  To " + accountTo.getAdescription();
		Transaction ta1 = new Transaction(description, value * (-1), date, uid, uid, uid);
		Transaction ta2 = new Transaction(description, value, date, uid, uid, uid);
		tm.createNew(ta1);
		tm.createNew(ta2);
	}

	private PreparedStatement fillValues(PreparedStatement ps, Account account) throws SQLException {
		ps.setString(1, account.getAtitle());
		ps.setString(2, account.getAdescription());
		ps.setFloat(3, account.getAamount());
		return ps;
	}
}
