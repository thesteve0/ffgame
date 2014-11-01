package com.openshift.ff.data;

import java.sql.Timestamp;

/**
 * Just a POJO to handle the JSON object from the User service
 * Created by spousty on 11/1/14.
 */
public class User {

    private int usersid;
    private String nick;
    private Integer points;
    private String notes;
    public static String entrytimestamp = "";

    public int getUsersid() {
        return usersid;
    }

    public void setUsersid(int usersid) {
        this.usersid = usersid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public static String getEntrytimestamp() {
        return entrytimestamp;
    }

    public static void setEntrytimestamp(String entrytimestamp) {
        User.entrytimestamp = entrytimestamp;
    }
}
