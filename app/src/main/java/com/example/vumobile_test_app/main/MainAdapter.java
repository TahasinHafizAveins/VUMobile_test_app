package com.example.vumobile_test_app.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vumobile_test_app.R;
import com.example.vumobile_test_app.model.Images;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {

    private MainActivity mainActivity;
    private List<Images> imagesList;
    private LayoutInflater layoutInflater;
    private RecyclerView mRecyclerView;


    public MainAdapter(MainActivity mainActivity,RecyclerView recyclerView) {
         this.mainActivity =mainActivity;
         this.imagesList = new ArrayList<>();
         layoutInflater = LayoutInflater.from(mainActivity);
         mRecyclerView = recyclerView;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View view = layoutInflater.inflate(R.layout.row,parent,false);

        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        Images images = imagesList.get(position);
        holder.bind(images);
    }

    @Override
    public int getItemCount() {
        return imagesList.size();
    }

    public  void addImage(Images images){
        imagesList.add(images);
        int position = imagesList.indexOf(images);
        notifyItemInserted(position);
    }

    public Images getImages(int position){
        return this.imagesList.get(position);
    }
    private int getPosition(Images images){
        for (Images x:imagesList){
            if (x.getId().equals(images.getId())){
                return imagesList.indexOf(x);
            }
        }
        return -1;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    public class  MainHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_name;
        ImageView imageView;

        public MainHolder(@NonNull View itemView) {
            super(itemView);


            tv_name = (TextView)itemView.findViewById(R.id.textview_row);
            imageView = (ImageView) itemView.findViewById(R.id.image_row);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mainActivity.startActivity(imagesList.get(getAdapterPosition()));
        }

        public void bind(Images images) {
            tv_name.setText(images.getFirst_name());
            Picasso.get().load(images.getAvatar()).into(imageView);
        }
    }
}
