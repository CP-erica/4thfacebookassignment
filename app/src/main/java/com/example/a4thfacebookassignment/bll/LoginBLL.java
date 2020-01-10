package com.example.a4thfacebookassignment.bll;

import com.example.a4thfacebookassignment.api.UsersAPI;
import com.example.a4thfacebookassignment.model.User;
import com.example.a4thfacebookassignment.strictmode.StrictModeClass;
import com.example.a4thfacebookassignment.url.Url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBLL {
    private UsersAPI usersAPI = Url.getInstance().create(UsersAPI.class);
    private boolean isloggedIn = false;

    public boolean userLogin(User user) {
        Call<User> userCall = usersAPI.userLogin(user);
        StrictModeClass.StrictMode();

        try{
            Response<User> loginResponse = userCall.execute();
            if(loginResponse.isSuccessful()){
                isloggedIn = true;
                Url.token += loginResponse.body().getToken();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return isloggedIn;
    }
}
