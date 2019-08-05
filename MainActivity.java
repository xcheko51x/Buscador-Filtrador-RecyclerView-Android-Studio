package com.xcheko51x.buscadorrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etBuscador;
    RecyclerView rvLista;
    AdaptadorUsuarios adaptador;

    List<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        etBuscador = findViewById(R.id.etBuscador);
        etBuscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrar(s.toString());
            }
        });

        rvLista = findViewById(R.id.rvLista);
        rvLista.setLayoutManager(new GridLayoutManager(this, 1));

        listaUsuarios = new ArrayList<>();

        listaUsuarios.add(new Usuario("Ana", "12345", "ana@mail.com"));
        listaUsuarios.add(new Usuario("Luis", "56789", "luis@mail.com"));
        listaUsuarios.add(new Usuario("Sergio", "98765", "sergio@mail.com"));
        listaUsuarios.add(new Usuario("Cesar", "54321", "cesar@mail.com"));
        listaUsuarios.add(new Usuario("Laura", "82123", "laura@mail.com"));

        adaptador = new AdaptadorUsuarios(MainActivity.this, listaUsuarios);
        rvLista.setAdapter(adaptador);
    }

    public void filtrar(String texto) {
        ArrayList<Usuario> filtrarLista = new ArrayList<>();

        for(Usuario usuario : listaUsuarios) {
            if(usuario.getNombre().toLowerCase().contains(texto.toLowerCase())) {
                filtrarLista.add(usuario);
            }
        }

        adaptador.filtrar(filtrarLista);
    }
}
