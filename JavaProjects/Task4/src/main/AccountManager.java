package main;

import interfaces.*;
import objects.Account;
import objects.Transaction;
import objects.dbConnector;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountManager implements DataPlugin {
	private int uid;
	private dbConnector db;
	private TransactionManager tm;

	public AccountManager(int uid) {
		this.uid = uid;
		this.db = new dbConnector();
		this.tm = new TransactionManager(uid);
	}

	public void show(int aid) throws SQLException {
		String stmt = "SELECT * FROM accounts WHERE aid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		ps.setInt(1, aid);
		// TODO
		db.runStmt(ps);
	}

	public void createNew(Account account) throws SQLException {
		String stmt = "INSERT INTO accounts (atitle, adescription, aamount, uid) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, account);
		ps.setInt(4, uid);
		db.runStmt(ps);
	}

	public void mod(Account accountOld, Account accountNew) throws SQLException {
		mod(accountOld.getAid(), accountNew);
	}

	public void mod(int aidOld, Account account) throws SQLException {
		String stmt = "UPDATE accounts SET atitle = ?, adescription = ?, aamount = ? WHERE aid = ?";
		PreparedStatement ps = db.getConnection().prepareStatement(stmt);
		fillValues(ps, account);
		ps.setInt(4, aidOld);
		db.runStmt(ps);
	}

	public void delete(Account account) throws SQLException {
		delete(account.getAid());
	}

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

	@Override
	public String getTitle() {
		return "AccountManager";
	}

	@Override
	public String getDescription() {
		return "Manage of Accounts";
	}

	@Override
	public ArrayList<String> getFunctions() {
		ArrayList<String> Functions = new ArrayList<String>();
		Functions.add("show");
		Functions.add("create");
		Functions.add("modify");
		Functions.add("transfer");
		Functions.add("delete");
		return Functions;
	}

	@Override
	public int getID() {
		return 1;
	}
}
