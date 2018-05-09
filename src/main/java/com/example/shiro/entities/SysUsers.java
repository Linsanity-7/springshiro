package com.example.shiro.entities;

import java.util.Date;

public class SysUsers {
    private Integer id;

    private String username;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Integer valid;

    private Date createdtime;

    private Date modifiedtime;

    private String createduser;

    private String modifieduser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Date getModifiedtime() {
        return modifiedtime;
    }

    public void setModifiedtime(Date modifiedtime) {
        this.modifiedtime = modifiedtime;
    }

    public String getCreateduser() {
        return createduser;
    }

    public void setCreateduser(String createduser) {
        this.createduser = createduser == null ? null : createduser.trim();
    }

    public String getModifieduser() {
        return modifieduser;
    }

    public void setModifieduser(String modifieduser) {
        this.modifieduser = modifieduser == null ? null : modifieduser.trim();
    }

    @Override
    public String toString() {
        return "SysUsers{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", valid=" + valid +
                ", createdtime=" + createdtime +
                ", modifiedtime=" + modifiedtime +
                ", createduser='" + createduser + '\'' +
                ", modifieduser='" + modifieduser + '\'' +
                '}';
    }
}