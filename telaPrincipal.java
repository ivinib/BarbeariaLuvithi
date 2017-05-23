package com.example.dourado_dtona.barbearia40;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;

public class telaPrincipal extends ListActivity {

//    private Toast toast;
//    private long lastBackPressTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_tela_principal);

        BD bd = new BD(this);

        List<Usuario> list = bd.buscar();
        setListAdapter(new UsuarioAdapter(this, list));

    }

    public void Sair(View v) {
        //Cria o gerador do AlertDialog
        //android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        //define o titulo
        //builder.setTitle("Logout");
        //define a mensagem
        //builder.setMessage("Deseja mesmo sair?");
        //define um botão como positivo
        //builder.setPositiveButton("Fazer logout", new DialogInterface.OnClickListener() {
          //  public void onClick(DialogInterface arg0, int arg1) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            //}
        //});
        //define um botão como negativo.
        //builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
         //   public void onClick(DialogInterface arg0, int arg1) {

           // }
        //});
        //cria o AlertDialog
        //builder.create();
        //Exibe
        //builder.show();
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, Addhorario.class);
        startActivity(intent);
    }

}
