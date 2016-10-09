package com.henrymeza.mascotasmenufragment.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by henry on 06/10/2016.
 */

public class Mascota implements Parcelable {
    private String nombre;
    private int foto;
    private int rank;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Mascota(String nombre, int foto, int rank){
        this.nombre=nombre;
        this.foto=foto;
        this.rank=rank;
    }

    public Mascota(Parcel in){
        this.nombre=in.readString();
        this.foto=in.readInt();
        this.rank=in.readInt();
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeInt(foto);
        dest.writeInt(rank);
    }
    public static final Parcelable.Creator<Mascota> CREATOR = new Parcelable.Creator<Mascota>() {
        public Mascota createFromParcel(Parcel source) {
            return new Mascota(source);
        }

        public Mascota[] newArray(int size) {
            return new Mascota[size];
        }
    };
}
