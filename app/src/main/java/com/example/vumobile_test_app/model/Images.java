package com.example.vumobile_test_app.model;

import java.io.Serializable;

public class Images implements Serializable {
    private String first_name;
    private String id;
    private String avatar;

    public Images() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
