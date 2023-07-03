package com.example.usodejsonapirestfulconparmetrosenelheaderusandovolley.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usodejsonapirestfulconparmetrosenelheaderusandovolley.R;
import com.example.usodejsonapirestfulconparmetrosenelheaderusandovolley.modelos.ModeloCliente;

import java.util.ArrayList;

public class    AdaptadorCliente extends ArrayAdapter<ModeloCliente> {
    public AdaptadorCliente(Context context, ArrayList<ModeloCliente> datos) {
        super(context, R.layout.layout_clientes, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.layout_clientes, null);

        TextView lblidentificacion = (TextView)item.findViewById(R.id.lblnombre);
        lblidentificacion.setText(getItem(position).getNombres());

        TextView lblNombre = (TextView)item.findViewById(R.id.lblidentificacion);
        lblNombre.setText(getItem(position).getIdentificacion());

        TextView lbldireccion = (TextView)item.findViewById(R.id.lbldireccion);
        lbldireccion.setText(getItem(position).getDireccion());

        TextView lblcorreo = (TextView)item.findViewById(R.id.lblcorreo);
        lblcorreo.setText(getItem(position).getCorreo());

        TextView lbltelefono = (TextView)item.findViewById(R.id.lbltelefono);
        lbltelefono.setText(getItem(position).getTelefono());

        return(item);
    }
}
