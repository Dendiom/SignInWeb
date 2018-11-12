package com.example.signinweb.bean;

import java.math.BigInteger;
import java.sql.Timestamp;

public class User {

    private Long id;
    private String username;
    private String password;
    private String nickname;
    private Boolean sex;
    private String grade;
    private String phone;
    private String mail;
    private String description;
    private Timestamp gmt_create;
    private Timestamp gmt_modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Timestamp gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Timestamp getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Timestamp gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public User() {}

    public User(Long id, String username, String password, String nickname, Boolean sex, String grade, String phone,
                String mail, String description) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.sex = sex;
        this.grade = grade;
        this.phone = phone;
        this.mail = mail;
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", grade='" + grade + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", description='" + description + '\'' +
                ", gmt_create=" + gmt_create +
                ", gmt_modified=" + gmt_modified +
                '}';
    }
}
