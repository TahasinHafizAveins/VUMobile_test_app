package com.example.vumobile_test_app.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.vumobile_test_app.R;
import com.example.vumobile_test_app.model.Images;
import com.example.vumobile_test_app.showImage.ShowFullImageActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContact.View {

    RecyclerView recyclerView;
    MainAdapter adapter;
    private List<Images> imagesList;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
        adapter = new MainAdapter(this,recyclerView);
        this.imagesList = new ArrayList<>();
        initView();


    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        mPresenter.getAllImage();
    }

    @Override
    public void renderImages(List<Images> imagesList) {
        for (Images images : imagesList){
            adapter.addImage(images);
        }
    }

    @Override
    public void startActivity(Images images) {
        Intent intent = new Intent(MainActivity.this, ShowFullImageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("fullImage", images);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
