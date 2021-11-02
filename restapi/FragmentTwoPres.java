package com.publicicat.restapi;

import android.content.Context;

import java.util.ArrayList;

public class FragmentTwoPres implements FragmentTwoIntPres {

    private final FragmentTwoInt fragmentTwoInt;
    private final Context context;
    private DbConstructor dbConstructor;

    private ArrayList<Constructor> mascota;

    public FragmentTwoPres(FragmentTwoInt fragmentTwoInt, Context context){
        this.fragmentTwoInt = fragmentTwoInt;
        this.context = context;
        obtenerMascotaBaseDatos();
    }

    @Override
    public void obtenerMascotaBaseDatos() {
        dbConstructor = new DbConstructor(context);
        mascota = dbConstructor.obtenerDatosUnaMascotaDb();
        mostrarMascotaRV();
    }

    @Override
    public void mostrarMascotaRV() {
        fragmentTwoInt.initAdapterRV(fragmentTwoInt.crearAdaptador(mascota));
        fragmentTwoInt.generarGridLayour();
    }
}

