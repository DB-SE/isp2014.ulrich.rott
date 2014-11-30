package main;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import objects.Transaction;
import objects.dbConnector;

public class TransactionManager {
    private int uid;
    private dbConnector db;

    public TransactionManager(int uid) {
        this.uid = uid;
        this.db = new dbConnector();
    }

    public void show(int tid) throws SQLException{
        String stmt = "SELECT * FROM transactions WHERE tid = ?";
        PreparedStatement ps = db.getConnection().prepareStatement(stmt);
        ps.setInt(1, tid);
        //TODO
        db.runStmt(ps);
    }

    //#ifdef tInsertion
    public void createNew(Transaction transaction) throws SQLException {
        String stmt = "INSERT INTO transactions (description, amount, date, cid, aid, uid) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = db.getConnection().prepareStatement(stmt);
        fillValues(ps, transaction);
        ps.setInt(6, uid);
        db.runStmt(ps);
    }
    //#endif
    
    //#ifdef tModification
    public void mod(Transaction transactionOld, Transaction transactionNew) throws SQLException{
        mod(transactionOld.getTid(), transactionNew);
    }
    
    public void mod(int oldtid, Transaction transaction) throws SQLException {
        String stmt = "UPDATE transactions SET description = ?, amount = ?, date = ?, cid = ?, aid = ? WHERE tid = ?";
        PreparedStatement ps = db.getConnection().prepareStatement(stmt);
        fillValues(ps, transaction);
        ps.setInt(6, oldtid);
        db.runStmt(ps);
    }
    //#endif

    //#ifdef tDelete
    public void delete(Transaction transaction) throws SQLException {
        delete(transaction.getTid());
    }

    public void delete(int tid) throws SQLException {
        String stmt = "DELETE FROM transactions WHERE tid = ?";
        PreparedStatement ps = db.getConnection().prepareStatement(stmt);
        ps.setInt(1, tid);
    }
    //#endif

    private PreparedStatement fillValues(PreparedStatement ps, Transaction transaction) throws SQLException{
        ps.setString(1, transaction.getDescription());
        ps.setFloat(2, transaction.getAmount());
        ps.setDate(3, transaction.getDate());
        ps.setInt(4, transaction.getCid());
        ps.setInt(5, transaction.getAid());
        return ps;
    }

}
