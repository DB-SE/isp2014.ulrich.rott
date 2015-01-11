
public  class  User {
	
    private int uid = -1;

	
    private String username;

	
    private String realname;

	
    private String email;

	
    private String password;

	

    public User(int uid, String username, String realname, String email, String password, int gid) {
        this.uid = uid;
        this.username = username;
        this.realname = realname;
        this.email = email;
        this.password = password;
    }

	

    public User(String username, String realname, String email, String password) {
        this.username = username;
        this.realname = realname;
        this.email = email;
        this.password = password;
    }

	

    /**
     * *********** GETTER-SETTER-START*************
     */
    public int getUid() {
        return uid;
    }

	

    public void setUid(int uid) {
        this.uid = uid;
    }

	

    public String getUsername() {
        return username;
    }

	

    public void setUsername(String username) {
        this.username = username;
    }

	

    public String getRealname() {
        return realname;
    }

	

    public void setRealname(String realname) {
        this.realname = realname;
    }

	

    public String getEmail() {
        return email;
    }

	

    public void setEmail(String email) {
        this.email = email;
    }

	

    public String getPassword() {
        return password;
    }

	

    public void setPassword(String password) {
        this.password = password;
    }


}
