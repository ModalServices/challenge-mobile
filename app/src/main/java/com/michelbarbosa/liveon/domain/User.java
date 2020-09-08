package com.michelbarbosa.liveon.domain;

import java.util.List;

public class User {

    private String urlPictureAvatar;
    private String username;
    private String fullname;
    private String city;
    private String uf;
    private List<Order> orderList;

    public User(String urlPictureAvatar, String username, String fullname, String city, String uf, List<Order> orderList) {
        this.urlPictureAvatar = urlPictureAvatar;
        this.username = username;
        this.fullname = fullname;
        this.city = city;
        this.uf = uf;
        this.orderList = orderList;
    }

    public String getUrlPictureAvatar() {
        return urlPictureAvatar;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
