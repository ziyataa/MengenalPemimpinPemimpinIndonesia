package com.ziyata.mengenalpemimpinpemimpinindonesia;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    String [] namaPresiden, isiPresiden;
    int [] imgPresiden;

    public Adapter(Context context, String[] namaPresiden, String[] isiPresiden, int[] imgPresiden) {
        this.context = context;
        this.namaPresiden = namaPresiden;
        this.isiPresiden = isiPresiden;
        this.imgPresiden = imgPresiden;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_presiden,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtListTitle.setText(namaPresiden[i]);
        Glide.with(context).load(imgPresiden[i]).into(viewHolder.imgList);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailPresidenActivity.class);
                pindah.putExtra("np", namaPresiden[i]);
                pindah.putExtra("ip", isiPresiden[i]);
                pindah.putExtra("imgp", imgPresiden[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imgPresiden.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtListTitle;
        ImageView imgList;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtListTitle = itemView.findViewById(R.id.txtListTitle);
            imgList = itemView.findViewById(R.id.imgList);
        }
    }
}
