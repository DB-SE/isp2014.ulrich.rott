package objects;
public class Accounts {
	private int aid;
	private String atitle;
	private String adescription;
	private double aamount;
	private int uid;

	public Accounts(int aid, String atitle, String adescription, double aamount, int uid) {
		this.aid = aid;
		this.atitle = atitle;
		this.adescription = adescription;
		this.aamount = aamount;
		this.uid = uid;
	}

	public Accounts(String atitle, String adescription, double aamount, int uid) {
		this.atitle = atitle;
		this.adescription = adescription;
		this.aamount = aamount;
		this.uid = uid;
	}
	
	/************** GETTER-SETTER-START**************/
	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAdescription() {
		return adescription;
	}

	public void setAdescription(String adescription) {
		this.adescription = adescription;
	}

	public double getAamount() {
		return aamount;
	}

	public void setAamount(double aamount) {
		this.aamount = aamount;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	/************** GETTER-SETTER-END**************/
}
