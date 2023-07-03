package com.example.usodejsonapirestfulconparmetrosenelheaderusandovolley;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.usodejsonapirestfulconparmetrosenelheaderusandovolley.adaptadores.AdaptadorCliente;
import com.example.usodejsonapirestfulconparmetrosenelheaderusandovolley.modelos.ModeloCliente;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lstClientes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstClientes = (ListView) findViewById(R.id.lstUser);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.uealecpeterson.net/public/clientes/search";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject JSONlista =  new JSONObject(response);
                            JSONArray JSONlistaUsuarios= JSONlista.getJSONArray("clientes");
                            ArrayList<ModeloCliente> lstProductoss = ModeloCliente.JsonObjectsBuild(JSONlistaUsuarios);
                            AdaptadorCliente adapatorUsuario = new AdaptadorCliente( getApplicationContext(), lstProductoss);
                            lstClientes.setAdapter(adapatorUsuario);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),  error.getMessage(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headerMap = new HashMap<String, String>();
                headerMap.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZHVzciI6NDYsImVtYWlsIjoiY2FybG9zQGdtYWlsLmNvbSIsInRpcG9fdXNlciI6MywiZXN0YWJsZWNpbWllbnRvX2lkIjoxLCJiZF9ub21icmUiOiJ1Nzg3OTU2NDQyX2FwaSIsImJkX3VzdWFyaW8iOiJ1Nzg3OTU2NDQyX2FwaSIsImJkX2NsYXZlIjoiVXRlcTIwMjIqIiwiYmRfaG9zdCI6ImxvY2FsaG9zdCIsImJkX2lwIjoiIiwiaWF0IjoxNjg4MTA2NTY5LCJleHAiOjE2ODg0NjY1Njl9.9m-pEFsvAFqNIEPkIxioHs3-z0EqiMqSWFBeNLKxHFA");
                return headerMap;
            }
            protected Map<String, String> getParams(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("fuente", "1");
                return params;
            }
        };
        queue.add(stringRequest);
    }
}

