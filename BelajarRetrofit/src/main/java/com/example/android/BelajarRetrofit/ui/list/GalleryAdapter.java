package com.example.android.BelajarRetrofit.ui.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.BelajarRetrofit.R;
import com.example.android.BelajarRetrofit.data.model.Car;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.CarViewHolder> {
    private Context context;
    private List<Car> carList;

    public GalleryAdapter(Context context){this.context = context; }

    public void setData(List<Car> carList){
        this.carList = carList;
        notifyDataSetChanged();
    }

    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CarViewHolder holder, int position){
        Car car= carList.get(position);
        holder.tvCarName.setText(car.getMake());
        Picasso.with(context)
                .load(car.getImgeUrl())
                .into(holder.imgAvatar);
    }
    @Override
    public int getItemCount(){
        if (carList == null) return 0;
        return carList.size();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAvatar;
        TextView tvCarName;

        public CarViewHolder(View itemView){
            super(itemView);
            tvCarName = itemView.findViewById(R.id.tv_car_name);
            imgAvatar = itemView.findViewById(R.id.img_avatar);



        }
    }
}
