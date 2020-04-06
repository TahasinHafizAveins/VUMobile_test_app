package com.example.vumobile_test_app.main;

import android.util.Log;

import com.example.vumobile_test_app.api.JsonApi;
import com.example.vumobile_test_app.api.ServiceGenerator;
import com.example.vumobile_test_app.model.Images;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContact.Presenter {

    private MainContact.View mView;

    public MainPresenter(MainContact.View mView) {
        this.mView = mView;
    }

    @Override
    public void getAllImage() {

        JsonApi api = ServiceGenerator.createService(JsonApi.class);

        api.getImageandName().enqueue(new Callback<List<Images>>() {
            @Override
            public void onResponse(Call<List<Images>> call, Response<List<Images>> response) {
                Log.d("getProject:","execute");
                if(response.isSuccessful()){
                    List<Images> imagesList = response.body();
                    mView.renderImages(imagesList);
                    Log.d("getImages:","Successful");
                }
            }

            @Override
            public void onFailure(Call<List<Images>> call, Throwable throwable) {
                Log.d("getImages:","ussuccessful"+throwable.getMessage());
            }
        });


    }
}
