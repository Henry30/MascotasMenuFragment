package com.henrymeza.mascotasmenufragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.henrymeza.mascotasmenufragment.adapter.MascotaAdaptador;
import com.henrymeza.mascotasmenufragment.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MascotasFavoritas extends AppCompatActivity {
    ArrayList<Mascota> lstObjMascotaTop5;
    ArrayList<Mascota> lstObjMascotaTemp;
    ArrayList<Mascota> lstObjMascota;
    private RecyclerView rvListaMascotas;
    private Toolbar mnuToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

       /* mnuToolBar=(Toolbar)findViewById(R.id.miactionbar);
        mnuToolBar.setTitle("");

        mnuToolBar.setLogo(R.drawable.cat_footprint_48);
        setSupportActionBar(mnuToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(false);*/
        mnuToolBar=(Toolbar)findViewById(R.id.miactionbar);
        mnuToolBar.setTitle("");

        mnuToolBar.setLogo(R.drawable.cat_footprint_48);
        setSupportActionBar(mnuToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowCustomEnabled(false);

//Recycler View
        rvListaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }
    public  boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        MenuItem mnuRank=menu.findItem(R.id.mnuRanking);
        MenuItem mnuAbout=menu.findItem(R.id.mnuAbout);
        MenuItem mnuContacto=menu.findItem(R.id.mnuContacto);
        mnuRank.setVisible(false);
        mnuAbout.setVisible(false);
        mnuContacto.setVisible(false);
        return true;
    }
   /* public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.mnuAbout:
                Intent i= new Intent(this,AcercadeActivity.class);
                startActivity(i);
                break;
            case R.id.mnuContacto:
                Intent i3= new Intent(this,ContactoActivity.class);
                startActivity(i3);
                break;
            case R.id.mnuRanking:
                break;
        }
        return true;

    }*/
    public void inicializarAdaptador(){

        MascotaAdaptador adaptador= new MascotaAdaptador(lstObjMascota,this);
        rvListaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        lstObjMascota= new ArrayList<Mascota>();
        Bundle b = getIntent().getExtras();
        Mascota obMascota;
        int vlongitud=b.getInt(getResources().getString(R.string.LONGITUD_LISTA));
        for(int x=0;x<vlongitud;x++) {
            obMascota = b.getParcelable(getResources().getString(R.string.OBJETO_MASCOTA) +String.valueOf(x));
            lstObjMascota.add(obMascota);
        }

    }
}
