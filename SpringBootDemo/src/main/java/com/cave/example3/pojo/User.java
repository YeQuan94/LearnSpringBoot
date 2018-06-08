package com.cave.example3.pojo;

import javax.persistence.Column;
import javax.persistence.Table;

@Table( name = "s_user")
public class User {

    /**
     * `uid` int(11) NOT NULL AUTO_INCREMENT,
     *   `username` varchar(255) DEFAULT NULL,
     *   `nickname` varchar(255) DEFAULT NULL,
     *   `password` varchar(255) DEFAULT NULL,
     *   `phoneCheckCode` varchar(255) DEFAULT NULL,
     *   `checkCode` varchar(255) DEFAULT NULL,
     *   PRIMARY KEY (`uid`)
     */

    private Integer uid;
    private String username;
    private String nickname;
    private String password;
    @Column( name = "phoneCheckCode")
    private String phoneCheckCode;
    @Column( name = "checkCode")
    private String checkCode;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneCheckCode() {
        return phoneCheckCode;
    }

    public void setPhoneCheckCode(String phoneCheckCode) {
        this.phoneCheckCode = phoneCheckCode;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", phoneCheckCode='" + phoneCheckCode + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }
}
