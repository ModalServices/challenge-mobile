package com.michelbarbosa.liveon.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserProfileResponse {

    @SerializedName("success")
    private boolean success;

    @SerializedName("method")
    private String method;

    @SerializedName("token")
    private String token;

    @SerializedName("avatar_url")
    private String avatar_url;

    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("city")
    private String city;

    @SerializedName("state_abbr")
    private String state_abbr;

    @SerializedName("orders")
    private List<OrderResponse> orders;

    public UserProfileResponse(boolean success, String method, String token, String avatar_url,
                               String email, String username, String fullname, String city,
                               String state_abbr, List<OrderResponse> orders) {
        this.success = success;
        this.method = method;
        this.token = token;
        this.avatar_url = avatar_url;
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.city = city;
        this.state_abbr = state_abbr;
        this.orders = orders;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMethod() {
        return method;
    }

    public String getToken() {
        return token;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getEmail() {
        return email;
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

    public String getState_abbr() {
        return state_abbr;
    }

    public List<OrderResponse> getOrders() {
        return orders;
    }
}


