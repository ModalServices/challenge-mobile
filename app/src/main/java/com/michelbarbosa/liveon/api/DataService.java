package com.michelbarbosa.liveon.api;

import com.michelbarbosa.liveon.api.response.ProfileResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataService {

    @POST("api/v1/auth")
    Call<ProfileResponse> Auth(@Query("email") String email,
                               @Query("password") String password);

    @GET("api/v1/user/profile?")
    Call<ProfileResponse> Profile(@Query("token") String token);
}
