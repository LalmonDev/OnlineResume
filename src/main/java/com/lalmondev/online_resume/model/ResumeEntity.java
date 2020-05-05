package com.lalmondev.online_resume.model;

public class ResumeEntity {
    private int resume_id;
    private String name;
    private String sex;
    private String nation;
    private String date;
    private String face;
    private String marry;
    private String home;
    private Long phone;
    private String mail;
    private String job;
    private String city;
    private Long money;
    private String study_start_day;
    private String study_stop_day;
    private String school;
    private String major;
    private String degree;
    private String school_descrip;
    private String skill;
    private String job_experience;
    private String school_experience;
    private String award;
    private String interest;
    private String evaluate;

    public int getResume_id() {
        return resume_id;
    }

    public void setResume_id(int resume_id) {
        this.resume_id = resume_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public String getMarry() {
        return marry;
    }

    public void setMarry(String marry) {
        this.marry = marry;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getStudy_start_day() {
        return study_start_day;
    }

    public void setStudy_start_day(String study_start_day) {
        this.study_start_day = study_start_day;
    }

    public String getStudy_stop_day() {
        return study_stop_day;
    }

    public void setStudy_stop_day(String study_stop_day) {
        this.study_stop_day = study_stop_day;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSchool_descrip() {
        return school_descrip;
    }

    public void setSchool_descrip(String school_descrip) {
        this.school_descrip = school_descrip;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getJob_experience() {
        return job_experience;
    }

    public void setJob_experience(String job_experience) {
        this.job_experience = job_experience;
    }

    public String getSchool_experience() {
        return school_experience;
    }

    public void setSchool_experience(String school_experience) {
        this.school_experience = school_experience;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    @Override
    public String toString() {
        return "ResumeEntity{" +
                "resume_id=" + resume_id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", nation='" + nation + '\'' +
                ", date='" + date + '\'' +
                ", face='" + face + '\'' +
                ", marry='" + marry + '\'' +
                ", home='" + home + '\'' +
                ", phone=" + phone +
                ", mail='" + mail + '\'' +
                ", job='" + job + '\'' +
                ", city='" + city + '\'' +
                ", money=" + money +
                ", study_start_day='" + study_start_day + '\'' +
                ", study_stop_day='" + study_stop_day + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", degree='" + degree + '\'' +
                ", school_descrip='" + school_descrip + '\'' +
                ", skill='" + skill + '\'' +
                ", job_experience='" + job_experience + '\'' +
                ", school_experience='" + school_experience + '\'' +
                ", award='" + award + '\'' +
                ", interest='" + interest + '\'' +
                ", evaluate='" + evaluate + '\'' +
                '}';
    }
}
