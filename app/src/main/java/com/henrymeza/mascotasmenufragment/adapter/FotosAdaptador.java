package com.henrymeza.mascotasmenufragment.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.henrymeza.mascotasmenufragment.R;
import com.henrymeza.mascotasmenufragment.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by henry on 08/10/2016.
 */

public class FotosAdaptador extends RecyclerView.Adapter<FotosAdaptador.FotosViewHolder> {
    ArrayList<Mascota> lstObjMascota;
    int nuevoRank;

    Activity activity;
    public FotosAdaptador(ArrayList<Mascota> lstObjMascota,Activity activity) {
        this.lstObjMascota=lstObjMascota;
        this.activity=activity;
    }

    @Override
    public FotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotosmascota,parent,false);
        return new FotosAdaptador.FotosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final FotosViewHolder fotosViewHolder,final int position) {
        final Mascota objMascota=lstObjMascota.get(position);

        fotosViewHolder.tvRankCV.setText(String.valueOf(objMascota.getRank()));
        fotosViewHolder.imgFoto.setImageResource(objMascota.getFoto());


    }

    @Override
    public int getItemCount() {
        return lstObjMascota.size();
    }


    public static class FotosViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgFoto;
        private ImageView btnRank_MarcarCV;
        private TextView tvNombreCV;
        private TextView tvRankCV;

        public FotosViewHolder(View itemView){
            super(itemView);
            imgFoto=(ImageView)itemView.findViewById(R.id.imgFoto_FM);
            tvRankCV=(TextView)itemView.findViewById(R.id.tvRankCV_FM);

        }

    }
}
