package com.example.dourado_dtona.barbearia40;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.Toast;

public class ListUsersActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_principal);
		
		BD bd = new BD(this);
		
		List<Usuario> list = bd.buscar();
		setListAdapter(new UsuarioAdapter(this, list));
	}
}
