package src.books;

public class book {
    private int bid;
    private String bname;
    private String aname;
    private String pname;
    private int no_pages;

    public book() {
        this.bid = -1;
        this.bname = "";
        this.aname = "";
        this.pname = "";
        this.no_pages = 0;
    }

    public book(int bid, String bname, String aname, String pname, int no_pages) {
        this.bid = bid;
        this.bname = bname;
        this.aname = aname;
        this.pname = pname;
        this.no_pages = no_pages;
    }

    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }
    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getNo_pages() {
        return no_pages;
    }
    public void setNo_pages(int no_pages) {
        this.no_pages = no_pages;
    }

}
