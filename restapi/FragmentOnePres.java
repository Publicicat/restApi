package com.publicicat.restapi;

import android.content.Context;

import java.util.ArrayList;

public class FragmentOnePres implements FragmentOneIntPres {

    private final FragmentOneInt fragmentOneInt;
    private final Context context;
    private DbConstructor dbConstructor;

    private ArrayList<Constructor> mascotas;

    public FragmentOnePres(FragmentOneInt fragmentOneInt, Context context){
        this.fragmentOneInt = fragmentOneInt;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        dbConstructor = new DbConstructor(context);
        mascotas = dbConstructor.obtenerDatosDb();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        fragmentOneInt.initAdapterRV(fragmentOneInt.crearAdaptador(mascotas));
        fragmentOneInt.generarLinearLayour();
    }
}

