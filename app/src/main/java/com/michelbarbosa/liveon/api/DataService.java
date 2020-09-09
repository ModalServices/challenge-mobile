package com.michelbarbosa.liveon.api;

import com.michelbarbosa.liveon.api.response.OrderResponse;
import com.michelbarbosa.liveon.api.response.UserProfileResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataService {

    @POST("api/v1/auth")
    Call<UserProfileResponse> Auth(@Query("email") String email,
                                   @Query("password") String password);

    @GET("api/v1/user/profile?")
    Call<UserProfileResponse> Profile(@Query("token") String token);

    //get OrderResponse só há update no sqlite, nao existe insert
    @GET("api/v1/user/profile/orders?")
    Call<List<OrderResponse>> Orders(@Query("token") String token);

}
