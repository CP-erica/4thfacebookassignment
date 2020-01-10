package com.example.a4thfacebookassignment.api;

import com.example.a4thfacebookassignment.model.Post;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface PostAPI {
    @Multipart
    @POST("upload")
    Call<Post> uploadImage(@Part MultipartBody.Part img);

    @POST("addpost")
    Call<Void> addPost(@Body Post post);
}
