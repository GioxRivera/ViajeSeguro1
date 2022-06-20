package com.example.viajeseguro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistarReporteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistarReporteFragment extends Fragment {

    private Spinner usuario, clasificaicon, sector, foto;
    private EditText direccion, fecha, descripcion;
    private Button registar, cancelar;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistarReporteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistarReporteFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistarReporteFragment newInstance(String param1, String param2) {
        RegistarReporteFragment fragment = new RegistarReporteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        usuario = view.findViewById(R.id.spnUs);
        clasificaicon = view.findViewById(R.id.spnClasificacion);
        sector = view.findViewById(R.id.spnSector);
        foto = view.findViewById(R.id.spnFoto);
        direccion = view.findViewById(R.id.edtDireccion);
        fecha = view.findViewById(R.id.edtFecha);
        descripcion = view.findViewById(R.id.edtDescripcion);
        registar = view.findViewById(R.id.btnReportar);
        cancelar = view.findViewById(R.id.btnCancelarR);

        String listaUsua[] = {"Admin", "Jovana", "Luis"};
        //Adapter para spinner
        ArrayAdapter<String> UAdapter = new ArrayAdapter<String>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaUsua);
        usuario.setAdapter(UAdapter);

        String listaClasif[] = {"Robo", "Asalto", "Asesinato", "Abuso"};
        //Adapter para spinner
        ArrayAdapter<String> CAdapter = new ArrayAdapter<String>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaClasif);
        clasificaicon.setAdapter(CAdapter);

        String listaSector[] = {"Zapopan", "Tlaquepaque", "Tonalá"};
        //Adapter para spinner
        ArrayAdapter<String> SAdapter = new ArrayAdapter<String>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaSector);
        sector.setAdapter(SAdapter);

        direccion.requestFocus();

        Integer listaFotos[] = {R.drawable.asalto,R.drawable.robo,R.drawable.intento, R.drawable.asesi };
        //Adapter para spinner
        ArrayAdapter<Integer> FAdapter = new ArrayAdapter<Integer>(getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaFotos);
        foto.setAdapter(FAdapter);


        registar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!direccion.getText().toString().equals("") && !fecha.getText().toString().equals("") && !descripcion.getText().toString().equals("")) {
                    MenuActivity home = (MenuActivity) requireActivity();
                    //int fotx = Integer.parseInt(foto.getSelectedItem().toString());
                    home.reporteslist.add(new reporte(clasificaicon.getSelectedItem().toString(), usuario.getSelectedItem().toString(), descripcion.getText().toString(), fecha.getText().toString(), direccion.getText().toString(), sector.getSelectedItem().toString(), (Integer) foto.getSelectedItem()));
                    Toast.makeText(getContext(), "Reporte Registrado", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else{
                    Toast.makeText(getContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                }
                /*
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.fragments_login_container, new LoginFragment());
                ft.commit();
                 */

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            MenuActivity home = (MenuActivity) requireActivity();
            @Override
            public void onClick(View view) {
                limpiar();
            }
        });
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
        return inflater.inflate(R.layout.fragment_registar_reporte, container, false);
    }

    private void limpiar(){
        direccion.setText("");
        fecha.setText("");
        descripcion.setText("");
        direccion.requestFocus();
    }
}