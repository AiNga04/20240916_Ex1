package org.dev._2024_09_16_web_servlet.models;

import java.io.Serializable;
import java.sql.Date;

public class Usermodel implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String image;
    private String phone;
    private int roleid;
    private Date createdate;

    public Usermodel(String username, String password, String email, String fullname, String image, String phone, int roleid, Date createdate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.image = image;
        this.phone = phone;
        this.roleid = roleid;
        this.createdate = createdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Usermodel(){
        super();
    }

    public Usermodel(int id, String username, String password, String email, String fullname, String image, String phone, int roleid, Date createdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.image = image;
        this.phone = phone;
        this.roleid = roleid;
        this.createdate = createdate;
    }

    @Override
    public String toString() {
        return "Usermodel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", image='" + image + '\'' +
                ", phone='" + phone + '\'' +
                ", roleid=" + roleid +
                ", createdate=" + createdate +
                '}';
    }
}
