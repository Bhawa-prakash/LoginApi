package com.example.loginapi.Retrofit;



import com.example.loginapi.Model.loginResponse;

import okhttp3.RequestBody;
import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";



    public static void loginUser(RequestBody email, RequestBody password , Callback<loginResponse> callback) {
        RetrofitClient.getClient().loginUser(email,password).enqueue(callback);
    }






}