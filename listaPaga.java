package com.example.dourado_dtona.barbearia40;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class listaPaga extends ListActivity {

//    private Toast toast;
//    private long lastBackPressTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_lista_paga);
        BD bd = new BD(this);

        List<Usuario> list = bd.buscarPaga();
        setListAdapter(new UsuarioAdapter1(this, list));
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, Addhorario.class);
        startActivity(intent);
    }
}
