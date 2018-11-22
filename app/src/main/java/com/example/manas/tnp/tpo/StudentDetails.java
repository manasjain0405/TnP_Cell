package com.example.manas.tnp.tpo;

public class StudentDetails {

    private String name;
    private String phone_no;
    private String enrollment;
    private float grades_10;
    private float grades_12;
    private float grades_grad;
    private String address;
    private String email;
    private String gender;
    private String branch;
    public StudentDetails(){}

    public StudentDetails(String name, String phone_no, String enrollment, float grades_10, float grades_12, float grades_grad, String address, String email, String gender, String branch){
        this.name = name;
        this.phone_no = phone_no;
        this.enrollment = enrollment;
        this.grades_10 = grades_10;
        this.grades_12 = grades_12;
        this.grades_grad = grades_grad;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.branch = branch;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public float getGrades_10() {
        return grades_10;
    }

    public float getGrades_12() {
        return grades_12;
    }

    public float getGrades_grad() {
        return grades_grad;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public void setGrades_10(float grades_10) {
        this.grades_10 = grades_10;
    }

    public void setGrades_12(float grades_12) {
        this.grades_12 = grades_12;
    }

    public void setGrades_grad(float grades_grad) {
        this.grades_grad = grades_grad;
    }

    public String getBranch() {
        return branch;
    }

    public String getGender() {
        return gender;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}

