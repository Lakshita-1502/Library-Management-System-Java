package src.issues;

public class issue {
    private int issue_id;
    private int bid;
    private int uid;
    private String issue_date;
    private String return_date;
    private String returned;

    public issue() {
        this.issue_id = -1;
        this.bid = -1;
        this.uid = -1;
        this.issue_date = "";
        this.return_date = "";
        this.returned = "No";
    }

    public issue(int issue_id, int bid, int uid, String issue_date, String return_date, String returned) {
        this.issue_id = issue_id;
        this.bid = bid;
        this.uid = uid;
        this.issue_date = issue_date;
        this.return_date = return_date;
        this.returned = returned;
    }

    public int getIssue_id() {
        return issue_id;
    }
    public void setIssue_id(int issue_id) {
        this.issue_id = issue_id;
    }

    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getIssue_date() {
        return issue_date;
    }
    public void setIssue_date(String issue_date) {
        this.issue_date = issue_date;
    }

    public String getReturn_date() {
        return return_date;
    }
    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getReturned() {
        return returned;
    }
    public void setReturned(String returned) {
        this.returned = returned;
    }
}
