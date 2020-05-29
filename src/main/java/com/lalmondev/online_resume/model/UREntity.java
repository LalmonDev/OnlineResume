package com.lalmondev.online_resume.model;

public class UREntity {
    private int tableid;
    private String username;
    private int resumeid;
    private String style;

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getResumeid() {
        return resumeid;
    }

    public void setResumeid(int resumeid) {
        this.resumeid = resumeid;
    }

    @Override
    public String toString() {
        return "UREntity{" +
                "tableid=" + tableid +
                ", username='" + username + '\'' +
                ", resumeid=" + resumeid +
                ", style='" + style + '\'' +
                '}';
    }
}
