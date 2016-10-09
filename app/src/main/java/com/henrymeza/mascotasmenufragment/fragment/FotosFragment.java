package com.henrymeza.mascotasmenufragment.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.henrymeza.mascotasmenufragment.R;
import com.henrymeza.mascotasmenufragment.adapter.FotosAdaptador;
import com.henrymeza.mascotasmenufragment.adapter.MascotaAdaptador;
import com.henrymeza.mascotasmenufragment.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FotosFragment extends Fragment {
    public ArrayList<Mascota> lstObjMascota;
    private RecyclerView rvListaMascotas;


    public FotosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_fotos, container, false);

        View v=inflater.inflate(R.layout.fragment_fotos,container,false);

       rvListaMascotas=(RecyclerView) v.findViewById(R.id.rvFotosMascota);

        GridLayoutManager glm= new GridLayoutManager(getActivity(),3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }
    public void inicializarAdaptador(){
        FotosAdaptador adaptador= new FotosAdaptador(lstObjMascota,getActivity());
        rvListaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        lstObjMascota= new ArrayList<Mascota>();

        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 1));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 2));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 13));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 40));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 5));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 10));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 27));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 7));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 28));
        lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 16));
      /*  lstObjMascota.add(new Mascota("Bobby", R.drawable.imgperro6, 6));
        lstObjMascota.add(new Mascota("Toby", R.drawable.imggato, 7));
        lstObjMascota.add(new Mascota("Toby", R.drawable.imggato, 8));
        lstObjMascota.add(new Mascota("Toby", R.drawable.imggato, 9));
        lstObjMascota.add(new Mascota("Toby", R.drawable.imggato, 10));*/

    }
}
