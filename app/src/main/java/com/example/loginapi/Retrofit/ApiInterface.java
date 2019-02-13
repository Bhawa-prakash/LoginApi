package com.example.loginapi.Retrofit;



import com.example.loginapi.Model.loginResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {



//    @Multipart
//    @POST("api/api.php?req=login")
//    Call<loginResponse> loginUser(@Part("email_id") RequestBody email, @Part("password") RequestBody password);

 @Multipart

    @POST(" api/api.php?req=login")
    Call<loginResponse> loginUser(@Part("email_id")RequestBody email,@Part("password")RequestBody password);
}