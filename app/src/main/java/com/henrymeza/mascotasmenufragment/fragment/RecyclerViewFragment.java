package com.henrymeza.mascotasmenufragment.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.henrymeza.mascotasmenufragment.R;
import com.henrymeza.mascotasmenufragment.adapter.MascotaAdaptador;
import com.henrymeza.mascotasmenufragment.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by henry on 07/10/2016.
 */

public class RecyclerViewFragment extends Fragment {
    public ArrayList<Mascota> lstObjMascota;
    private RecyclerView rvListaMascotas;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v=inflater.inflate(R.layout.fragment_recyclerview,container,false);

        rvListaMascotas=(RecyclerView) v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(lstObjMascota,getActivity());

        rvListaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        lstObjMascota= new ArrayList<Mascota>();

        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 1));
        lstObjMascota.add(new Mascota("Ronny", R.drawable.imgperro2, 2));
        lstObjMascota.add(new Mascota("Dumy", R.drawable.imgperro3, 3));
        lstObjMascota.add(new Mascota("Donko", R.drawable.imgperro4, 4));
        lstObjMascota.add(new Mascota("Catty", R.drawable.imgperro1, 5));
        lstObjMascota.add(new Mascota("Bobby", R.drawable.imgperro6, 6));
        lstObjMascota.add(new Mascota("Toby", R.drawable.imggato, 7));

    }
}
