package com.mobile.androidrest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mobile.androidrest.api.APIService;
import com.mobile.androidrest.api.ApiClient;
import com.mobile.androidrest.api.tokenResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextEmailAddress, editTextTextPassword;
    Button btnsignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextEmailAddress = (EditText) findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = (EditText) findViewById(R.id.editTextTextPassword);
        btnsignin = (Button) findViewById(R.id.btnsignin);

        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // String email = editTextTextEmailAddress.getText().toString();
               // String password = editTextTextPassword.getText().toString();
               // Toast.makeText(MainActivity.this, "Email: " + email + " Password: "+password,Toast.LENGTH_LONG).show();
                CallLoginService();

            }
        });

    }

    private void CallLoginService(){

        //
        try{
            final String email =  editTextTextEmailAddress.getText().toString();
            final String password =  editTextTextPassword.getText().toString();

            APIService service = ApiClient.getClient().create(APIService.class);
            Call<ResponseBody> srvLogin = service.getToken(email, password);
            srvLogin.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        try {
                            String ResponseJson = response.body().string();
                            Gson objGson = new Gson();
                            tokenResponse objResp = objGson.fromJson(ResponseJson, tokenResponse.class);
                            Toast.makeText(MainActivity.this, objResp.getAcces_token(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(MainActivity.this, "Token Got Successfully , ", Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();

                        }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid try again", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "System error: "+t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this,"error check internet "+ e.toString(), Toast.LENGTH_SHORT).show();

        }
    }

}