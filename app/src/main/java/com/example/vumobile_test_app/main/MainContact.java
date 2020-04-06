package com.example.vumobile_test_app.main;

import com.example.vumobile_test_app.model.Images;

import java.util.List;

public interface MainContact {
    public interface Presenter{
        void getAllImage();
    }

    public interface View{
        void renderImages(List<Images> imagesList);
        void startActivity(Images images);
    }
}
