package com.example.vumobile_test_app.showImage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.vumobile_test_app.R;
import com.example.vumobile_test_app.model.Images;
import com.squareup.picasso.Picasso;

public class ShowFullImageActivity extends AppCompatActivity {

    ImageView iv_fullimg;
    Images images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_full_image);

        this.images = (Images) getIntent().getSerializableExtra("fullImage");

        iv_fullimg = findViewById(R.id.iv_full_img);
        Picasso.get().load(images.getAvatar()).fit().fit()
                .into(iv_fullimg);
    }
}
