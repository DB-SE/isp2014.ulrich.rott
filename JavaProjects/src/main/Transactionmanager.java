package main;

import java.sql.Date;
import objects.Transaction;

public class Transactionmanager {
	private int uid;

	public Transactionmanager(int uid) {
		this.uid = uid;
	}
	
	public void createNewTransaction(String description, double amount, Date date, int cid, int uid, Date date_added, int aid) {
		Transaction t = new Transaction(description, amount, date, cid, uid, date_added, aid);
		//SQL STATEMENT - INSERT
	}

	public void editTransaction(int tid) {
		//SQL STATEMENT - SELECT
		//OBJECT
		//SQL STATEMENT - UPDATE
	}

	public void deleteTransaction(int tid) {
		//SQL STATEMENT - DELETE
	}

}
