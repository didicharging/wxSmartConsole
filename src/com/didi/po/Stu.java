package com.didi.po;

public class Stu {
    private Integer sid;

    private String sname;

    private String spass;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    public String getSpass() {
        return spass;
    }

    public void setSpass(String spass) {
        this.spass = spass == null ? null : spass.trim();
    }

	@Override
	public String toString() {
		return "Stu [sid=" + sid + ", sname=" + sname + ", spass=" + spass + "]";
	}
   
    
}