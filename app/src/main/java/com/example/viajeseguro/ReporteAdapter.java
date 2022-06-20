package com.example.viajeseguro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReporteAdapter extends RecyclerView.Adapter<ReporteAdapter.ViewHolderDatos> implements View.OnClickListener {

    private ArrayList<reporte> listaReportes;
    private View.OnClickListener listener;

    public ReporteAdapter(ArrayList<reporte> listaRepo) {
        listaReportes = listaRepo;
    }

    @NonNull
    @Override
    public ReporteAdapter.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reporte_card, parent, false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReporteAdapter.ViewHolderDatos holder, int position) {
        holder.nombre.setText(listaReportes.get(position).getUsuarior());
        holder.foto.setImageResource(listaReportes.get(position).getFoto());
        holder.direccion.setText(listaReportes.get(position).getDireccion());
        holder.clasificacion.setText(listaReportes.get(position).getClasificacion());
        holder.fecha.setText(listaReportes.get(position).getFecha());
    }

    @Override
    public int getItemCount() {
        return listaReportes.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder{
        ImageView foto;
        TextView nombre, direccion, descripcion, clasificacion, fecha;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.imgCard);
            nombre = itemView.findViewById(R.id.txtNombrecard);
            direccion = itemView.findViewById(R.id.txtDirCard);
            clasificacion = itemView.findViewById(R.id.txtClasifCard);
            fecha = itemView.findViewById(R.id.txtFechaCard);
        }
    }
}
