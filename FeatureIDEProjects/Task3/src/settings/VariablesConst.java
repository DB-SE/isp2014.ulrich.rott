package settings;

public class VariablesConst {
    private final String url = "localhost:3306/REPLACE THIS WITH DB TITLE";
    private final String user = "REPLACE THIS WITH DB USERNAME";
    private final String password = "REPLACE THIS WITH DB PASSWORD";

    // options for permissions
    private boolean oRead;
    private boolean oWrite;

    // options for transactions
    private final boolean oTransaction = true;
    private final boolean oTaShow = true;
    private boolean oTaInsert = true;
    private boolean oTaMod;
    private boolean oTaDel;

    // options for accounts
    private boolean oAccount;
    private boolean oAtInsert;
    private boolean oAtMod;
    private boolean oAtDel;

    // options for categories
    private boolean oCategory;
    private boolean oCyInsert;
    private boolean oCyMod;
    private boolean oCyDel;

    // options for user settings
    private final boolean oUser = true;

    public VariablesConst(){
        oRead = true;
        oWrite = false;

        oTaInsert = true;
        oTaMod = false;
        oTaDel = false;

        oAccount = false;
        oAtInsert = false;
        oAtMod = false;
        oAtDel = false;

        oCategory = false;
        oCyInsert = false;
        oCyMod = false;
        oCyDel = false;
    }

    public boolean isoTaShow() {
        return oTaShow;
    }

    public void setoTaInsert(boolean oTaInsert) {
        this.oTaInsert = oTaInsert;
    }

    public boolean isoWrite() {
        return oWrite;
    }

    public void setoWrite(boolean oWrite) {
        if (oWrite = true){
            this.oRead = oWrite;
        }
        this.oWrite = oWrite;
    }

    public boolean isoRead() {
        return oRead;
    }

    public void setoRead(boolean oRead) {
        this.oRead = oRead;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public boolean isoTransaction() {
        return oTransaction;
    }

    public boolean isoTaInsert() {
        return oTaInsert;
    }

    public boolean isoTaMod() {
        return oTaMod;
    }

    public void setoTaMod(boolean oTaMod) {
        this.oTaMod = oTaMod;
    }

    public boolean isoTaDel() {
        return oTaDel;
    }

    public void setoTaDel(boolean oTaDel) {
        this.oTaDel = oTaDel;
    }

    public boolean isoAccount() {
        return oAccount;
    }

    public void setoAccount(boolean oAccount) {
        // oAccount <=> oAtInsert
        this.oAccount = oAccount;
        this.oAtInsert = oAccount;
    }

    public boolean isoAtInsert() {
        return oAtInsert;
    }

    public void setoAtInsert(boolean oAtInsert) {
        // oAccount <=> oAtInsert
        this.oAtInsert = oAtInsert;
        this.oAccount = oAtInsert;
    }

    public boolean isoAtMod() {
        return oAtMod;
    }

    public void setoAtMod(boolean oAtMod) {
        this.oAtMod = oAtMod;
    }

    public boolean isoAtDel() {
        return oAtDel;
    }

    public void setoAtDel(boolean oAtDel) {
        this.oAtDel = oAtDel;
    }

    public boolean isoCategory() {
        return oCategory;
    }

    public void setoCategory(boolean oCategory) {
        this.oCategory = oCategory;
    }

    public boolean isoCyInsert() {
        return oCyInsert;
    }

    public void setoCyInsert(boolean oCyInsert) {
        // oCyInsert <=> oCategory
        this.oCyInsert = oCyInsert;
        this.oCategory = oCyInsert;
    }

    public boolean isoCyMod() {
        return oCyMod;
    }

    public void setoCyMod(boolean oCyMod) {
        this.oCyMod = oCyMod;
    }

    public boolean isoCyDel() {
        return oCyDel;
    }

    public void setoCyDel(boolean oCyDel) {
        this.oCyDel = oCyDel;
    }

    public boolean isoUser() {
        return oUser;
    }
}