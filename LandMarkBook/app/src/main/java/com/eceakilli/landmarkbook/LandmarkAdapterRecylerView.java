package com.eceakilli.landmarkbook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eceakilli.landmarkbook.databinding.RecycelerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapterRecylerView extends RecyclerView.Adapter<LandmarkAdapterRecylerView.LandmarkHolder> {

    ArrayList<LandMark> landMarkArrayList;

    public LandmarkAdapterRecylerView(ArrayList<LandMark> landMarkArrayList) {
        this.landMarkArrayList = landMarkArrayList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//ViewHolder sınıfında bir obje olusturuldugunda çağrılacak method yani bindingi boarda baglıycaz
        RecycelerRowBinding recycelerRowBinding=RecycelerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recycelerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkAdapterRecylerView.LandmarkHolder holder, int position) {//layout içerisinde hangi verileri göstermek istiyorsak bu alanda gösteririz
        holder.binding.recyclerViewTextView.setText(landMarkArrayList.get(position).name);
        holder.landMark = landMarkArrayList.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                intent.putExtra("landmark",holder.landMark);
                holder.itemView.getContext().startActivity(intent);
               // Singleton singleton=Singleton.getInstance();
                // singleton.setSentLandmark(landMarkArrayList.get(position));

            }
        });
    }

    @Override
    public int getItemCount() {//xmlin kaç defa oluşturulacagını soyler o yuzden array liste kactane eleman var onu soyle yazacagız
        return landMarkArrayList.size();
    }

    public class  LandmarkHolder extends RecyclerView.ViewHolder{//Görünümlerimiz tutan yardımcı sınıf
            private RecycelerRowBinding binding;
            public LandMark landMark;
        public LandmarkHolder(RecycelerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }
}
