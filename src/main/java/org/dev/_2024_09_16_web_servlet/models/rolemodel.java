package org.dev._2024_09_16_web_servlet.models;

import java.io.Serializable;

public class rolemodel implements Serializable {

    public static final Long serialVersionUID = 1L;

    private String roleid;
    private String rolename;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public rolemodel() {
        super();
    }

    public rolemodel(String roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "rolemodel{" +
                "roleid='" + roleid + '\'' +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
