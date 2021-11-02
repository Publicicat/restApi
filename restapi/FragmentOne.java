package com.publicicat.restapi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentOne extends Fragment implements FragmentOneInt {

    private RecyclerView rvMascotas;
    private FragmentOneIntPres presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentOne newInstance(String param1, String param2) {
        FragmentOne fragment = new FragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_one, container, false);
        View v = inflater.inflate(R.layout.fragment_one, container, false);

        rvMascotas = v.findViewById(R.id.rv_mascotas);
        presenter = new FragmentOnePres(this, getContext());
        return v;

    }

    @Override
    public void generarLinearLayour() {
        rvMascotas.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public AdapterOne crearAdaptador(ArrayList<Constructor> mascotas) {
        AdapterOne adapter = new AdapterOne(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void initAdapterRV(AdapterOne adapter) {
        rvMascotas.setAdapter(adapter);
    }

    /*
    public void initList() {
        mascotas.add(new Constructor("Turtles Castle", "Being brave, by Elma Avdagic", "turtlescast@stone.com", 23, R.drawable.turtles_elma_avdagic));
        mascotas.add(new Constructor("Turtles Dance", "Dancing on the stone, by Bjorn Graaf", "turtles@stone.com", 23, R.drawable.turtles_bjorn_graaf));
        mascotas.add(new Constructor("Eyesfish", "Hu?, by Louis Hall", "fish@stone.com", 12, R.drawable.fish_louis_hall));
        mascotas.add(new Constructor("Tinny Dog", "I did no do that, by Sidiney Carlos", "dog@stone.com", 42, R.drawable.dog_sidiney_carlos));
        mascotas.add(new Constructor("Ham", "Did you call me, by Ricardo Rodriguez", "ham@stone.com", 82, R.drawable.hamster_ricardo_rodriguez));
        mascotas.add(new Constructor("Purr", "The sun shines on me and my eyes are blinking, by Yuki the Cat", "cat@stone.com", 62, R.drawable.yuki_the_cat_emrah_errr));
    }
     */


}