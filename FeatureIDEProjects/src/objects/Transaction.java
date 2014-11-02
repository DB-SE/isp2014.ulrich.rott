package objects;

import java.sql.Date;

public class Transaction {
	private int tid;
	private String description;
	private double amount;
	private Date date;
	private int cid;
	private int uid;
	private Date date_added;
	private int aid;

	public Transaction(int tid, String description, double amount, Date date, int cid, int uid, Date date_added, int aid) {
		this.tid = tid;
		this.description = description;
		this.amount = amount;
		this.date = date;
		this.cid = cid;
		this.uid = uid;
		this.date_added = date_added;
		this.aid = aid;
	}
	

	/************** GETTER-SETTER-START**************/
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}
	/************** GETTER-SETTER-END**************/
}
