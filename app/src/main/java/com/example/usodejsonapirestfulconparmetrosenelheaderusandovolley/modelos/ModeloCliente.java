package com.example.usodejsonapirestfulconparmetrosenelheaderusandovolley.modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ModeloCliente {

    private String identificacion;
    private String nombres;
    private String direccion;
    private String correo;
    private String telefono;


    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public ModeloCliente(JSONObject a) throws JSONException {

        identificacion= a.getString("identificacion").toString() ;
        nombres =  a.getString("nombre").toString() ;
        direccion =  a.getString("direccion").toString() ;
        correo =  a.getString("correo").toString() ;
        telefono= a.getString("telefonomovil").toString() ;


    }

    public static ArrayList<ModeloCliente> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<ModeloCliente> clientes = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            clientes.add(new ModeloCliente(datos.getJSONObject(i)));
        }
        return clientes;
    }
}
