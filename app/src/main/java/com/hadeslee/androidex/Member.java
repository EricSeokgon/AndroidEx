package com.hadeslee.androidex;

/**
 * Created by sklee on 2015-05-28.
 */
public class Member {
    private String name;
    private int age;
    private String[] hobby;
    private String v_id;
    private String v_pw;

    public Member(String name, int age, String[] hobby, String v_id, String v_pw) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.v_id = v_id;
        this.v_pw = v_pw;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getV_id() {
        return v_id;
    }

    public void setV_id(String v_id) {
        this.v_id = v_id;
    }

    public String getV_pw() {
        return v_pw;
    }

    public void setV_pw(String v_pw) {
        this.v_pw = v_pw;
    }
}
