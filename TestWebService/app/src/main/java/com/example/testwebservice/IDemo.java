package com.example.testwebservice;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IDemo {
    @GET("/demo")
    Call<Student> getDemo();
}
