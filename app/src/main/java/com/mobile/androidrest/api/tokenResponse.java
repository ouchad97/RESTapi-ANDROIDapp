package com.mobile.androidrest.api;

import com.google.gson.annotations.SerializedName;

public class tokenResponse {
    @SerializedName("acces_token")
    private String acces_token;

    @SerializedName("token_type")
    private String token_type;

    @SerializedName("email")
    private String email;

    public  tokenResponse(){}


    public void setAcces_token(String acces_token) {
        this.acces_token = acces_token;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcces_token() {
        return acces_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getEmail() {
        return email;
    }
}
