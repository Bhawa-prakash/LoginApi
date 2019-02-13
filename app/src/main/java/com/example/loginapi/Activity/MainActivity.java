package com.example.loginapi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginapi.Model.loginResponse;
import com.example.loginapi.R;
import com.example.loginapi.Retrofit.RestClient;
import com.example.loginapi.Utils.Utils;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText editEmail,editPassword;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       editEmail=findViewById(R.id.gmail);
       editPassword=findViewById(R.id.password);
        btnlogin=findViewById(R.id.button);


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gmail = editEmail.getText().toString().trim();
                String Password= editPassword.getText().toString().trim();

                RequestBody email = RequestBody.create(MediaType.parse("text/plain"), gmail);
                RequestBody password = RequestBody.create(MediaType.parse("text/plain"),Password);
                RestClient.loginUser(email, password, new Callback<loginResponse>() {
                    @Override
                    public void onResponse(Call<loginResponse> call, Response<loginResponse> response) {
                        Utils.dismissProgressDialog();

                        if (response != null && response.body() != null) {

                            loginResponse loginResponse = response.body();
                            if (Integer.parseInt(loginResponse.getStatus()) == 1) {
                                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                                Utils.displayToast(MainActivity.this, loginResponse.getMessage());

                            }
                        }
                    }



                    @Override
                    public void onFailure(Call<loginResponse> call, Throwable t) {

                        Utils.dismissProgressDialog();
                        Toast.makeText(MainActivity.this, "Invalid Credential", Toast.LENGTH_SHORT).show();

                    }
                });








            }
        });



    }

}
