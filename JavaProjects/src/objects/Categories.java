package objects;
public class Categories {
	private int cid;
	private String title;
	private int typeid;
	private String cdescription;
	private int cuid;

	public Categories(int cid, String title, int typeid, String cdescription, int cuid) {
		this.cid = cid;
		this.title = title;
		this.typeid = typeid;
		this.cdescription = cdescription;
		this.cuid = cuid;
	}

	/************** GETTER-SETTER-START**************/
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTypeid() {
		return typeid;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}

	public String getCdescription() {
		return cdescription;
	}

	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}

	public int getCuid() {
		return cuid;
	}

	public void setCuid(int cuid) {
		this.cuid = cuid;
	}
	/************** GETTER-SETTER-END**************/	
}
