package com.mobile.androidrest.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

// GET TOKEN API SERVICE
// region TokenActivityMethods

    @FormUrlEncoded
    @POST("/users/login")
    @Headers({
            "Content-Type: application/json",
          //  "Content-Type: application/x-www-form-urlencoded",
    })

    Call<ResponseBody> getToken(//@Field("grant_type") String grant_type,
                                @Field("email") String email,
                                @Field("password") String password
    );

}

