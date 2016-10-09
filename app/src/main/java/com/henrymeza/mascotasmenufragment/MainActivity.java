package com.henrymeza.mascotasmenufragment;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.henrymeza.mascotasmenufragment.adapter.MascotaAdaptador;
import com.henrymeza.mascotasmenufragment.adapter.PageAdapter;
import com.henrymeza.mascotasmenufragment.fragment.FotosFragment;
import com.henrymeza.mascotasmenufragment.fragment.RecyclerViewFragment;
import com.henrymeza.mascotasmenufragment.pojo.Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.mail.internet.NewsAddress;

public class MainActivity extends AppCompatActivity {
    RecyclerViewFragment fragmentReciclerView;
    ArrayList<Mascota> lstObjMascota;
    private RecyclerView rvListaMascotas;
    private Toolbar mnuToolBar;
    private ArrayList<Fragment> fragments= new ArrayList<>();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    //private ClipData.Item mnuEstrella;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      /* mnuToolBar=(Toolbar)findViewById(R.id.miactionbar);
        mnuToolBar.setTitle("");
        mnuToolBar.setLogo(R.drawable.cat_footprint_48);
        setSupportActionBar(mnuToolBar);
        //
        rvListaMascotas=(RecyclerView) findViewById(R.id.rvMascotas);
        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
*/
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        toolbar.setLogo(R.drawable.cat_footprint_48);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        if(toolbar !=null)
        {
            setSupportActionBar(toolbar);
        }
    }
    private ArrayList<Fragment> agregarFragments(){
        //ArrayList<Fragment> fragments= new ArrayList<>();
        fragmentReciclerView= new RecyclerViewFragment();
        //fragments.add(new RecyclerViewFragment());
        fragments.add(fragmentReciclerView);
        fragments.add(new FotosFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.ic_facedog);

    }
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
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
               //fragments.lstObjMascota
                //RecyclerViewFragment frm= new RecyclerViewFragment();

                lstObjMascota=fragmentReciclerView.lstObjMascota;
                Collections.sort(lstObjMascota, new Comparator<Mascota>() {
                    @Override
                    public int compare(Mascota m1, Mascota m2) {
                        return new Integer(m2.getRank()).compareTo(new Integer(m1.getRank()));
                    }
                });

                Intent i2= new Intent(this, MascotasFavoritas.class);

                for(int x=0;x<5;x=x+1) {
                    i2.putExtra(getResources().getString(R.string.OBJETO_MASCOTA) + String.valueOf(x), lstObjMascota.get(x));
                }

                i2.putExtra(getResources().getString(R.string.LONGITUD_LISTA), 5);

                startActivity(i2);

                break;
        }
        return true;

    }
   /* public void inicializarAdaptador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(lstObjMascota,this);

        rvListaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        lstObjMascota= new ArrayList<Mascota>();
        Bundle b = getIntent().getExtras();
        if(b!=null) {
            Mascota obMascota;
            int vlongitud=b.getInt(getResources().getString(R.string.LONGITUD_LISTA));
            for(int x=0;x<vlongitud;x++) {
                obMascota = b.getParcelable(getResources().getString(R.string.OBJETO_MASCOTA) +String.valueOf(x));
                lstObjMascota.add(obMascota);
            }
        }
        else {
            lstObjMascota.add(new Mascota("Catty", R.drawable.imgperro1, 1));
            lstObjMascota.add(new Mascota("Ronny", R.drawable.imgperro2, 2));
            lstObjMascota.add(new Mascota("Dumy", R.drawable.imgperro3, 3));
            lstObjMascota.add(new Mascota("Donko", R.drawable.imgperro4, 4));
            lstObjMascota.add(new Mascota("Lobo", R.drawable.imgperro5, 5));
            lstObjMascota.add(new Mascota("Bobby", R.drawable.imgperro6, 6));
            lstObjMascota.add(new Mascota("Toby", R.drawable.imggato, 7));
        }
    }*/
}
