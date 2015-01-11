public  class  Account {
	
    private int aid = -1;

	
    private String atitle;

	
    private String adescription;

	
    private float aamount = 0.00F;

	
    private int uid = -1;

	

    public Account(int aid, String atitle, String adescription, float aamount, int uid) {
        this.aid = aid;
        this.atitle = atitle;
        this.adescription = adescription;
        this.aamount = aamount;
        this.uid = uid;
    }

	

    public Account(String atitle, String adescription, float aamount, int uid) {
        this.atitle = atitle;
        this.adescription = adescription;
        this.aamount = aamount;
        this.uid = uid;
    }

	

    /**
     * *********** GETTER-SETTER-START*************
     */
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

	

    public float getAamount() {
        return aamount;
    }

	

    public void setAamount(float aamount) {
        this.aamount = aamount;
    }

	

    public int getUid() {
        return uid;
    }

	

    public void setUid(int uid) {
        this.uid = uid;
    }


}
