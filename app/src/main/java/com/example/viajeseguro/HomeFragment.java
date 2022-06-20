package com.example.viajeseguro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    ArrayList<reporte> listarepo;
    private RecyclerView recyclerView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       listarepo = new ArrayList<>();
       recyclerView = view.findViewById(R.id.recycler);

        int tipo = getActivity().getIntent().getIntExtra("tipoLista", 1);
        switch (tipo){
            case 1: //Mostrar lista de forma vertical
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                break;
            case 2: //Mostrar lista de forma de tabla
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                break;
        }

        cargarReporte();
        ReporteAdapter adaptador = new ReporteAdapter(listarepo);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Descripción" + listarepo.get(recyclerView.getChildAdapterPosition(view)).getDescripcion(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adaptador);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void cargarReporte() {
        MenuActivity home = (MenuActivity) requireActivity();
        listarepo.add(new reporte("Robo", "Jovana", "Fue un robo a mano armada", "25/05/2001", "Natividad Macias #789", "Constitucion", R.drawable.ic_map));

        for(reporte rep : home.reporteslist){
            listarepo.add(new reporte(rep.getClasificacion(), rep.getUsuarior(), rep.getDescripcion(), rep.getFecha(), rep.getDireccion(), rep.getSector(), rep.getFoto()));
        }


    }
}