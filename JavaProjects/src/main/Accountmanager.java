package main;

import objects.Accounts;

public class Accountmanager {
	private int uid;

	public Accountmanager(int uid) {
		this.uid = uid;
	}

	public void createNewAccount(String atitle, String adescription) {
		this.createNewAccount(atitle, adescription, 0);
	}

	public void createNewAccount(String atitle, String adescription, double aamount) {
		Accounts a = new Accounts(atitle, adescription, aamount, uid);
		//SQL STATEMENT - INSERT
	}

	public void editAccount(int aid, String atitle, String adescription, double aamount) {
		//SQL STATEMENT - SELECT
		//OBJECT
		//SQL STATEMENT - UPDATE
	}

	public void deleteAccount(int aid) {
		//SQL STATEMENT - DELETE
	}
	
	public void transfer(int fromAid, int toAid, double amount){
		//SQL STATEMENT - UPDATE
	}

}
