package com.example.manas.tnp.tpo;

public class PollForm {
    private String pollID;
    private String companyName;
    private String form_link;

    public PollForm() {

    }

    public PollForm(String pollID, String companyName, String form_link){
        this.pollID = pollID;
        this.companyName = companyName;
        this.form_link = form_link;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPollID() {
        return pollID;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPollID(String pollID) {
        this.pollID = pollID;
    }

    public String getForm_link() {
        return form_link;
    }

    public void setForm_link(String form_link) {
        this.form_link = form_link;
    }


}