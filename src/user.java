package src;

public class user {
    private int uid;
    private String uname;
    private String contact;
    private String address;

    public user(){
        this.uid = 0;
        this.uname = "";
        this.contact = "";
        this.address = "";
    }

    public user(int uid, String uname, String contact, String address) {
        this.uid = uid;
        this.uname = uname;
        this.contact = contact;
        this.address = address;
    }

    public int getUid() {
        return uid;
    }
    public void setUid(int user_id) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
