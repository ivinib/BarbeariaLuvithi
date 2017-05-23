package com.example.dourado_dtona.barbearia40;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class BD {
	private SQLiteDatabase bd;
	
	public BD(Context context){
		BDCore auxBd = new BDCore(context);
		bd = auxBd.getWritableDatabase();
	}
	
	
	public void inserir(Usuario usuario){
		ContentValues valores = new ContentValues();
		valores.put("nome", usuario.getNome());
		valores.put("email", usuario.getEmail());
		valores.put("telefone", usuario.getTelefone());
		valores.put("data", usuario.getData());
		valores.put("hora", usuario.getHora());
		valores.put("servico", usuario.getServico());
		valores.put("situacao", "pendente");
		bd.insert("barbearia", null, valores);
	}
	
	
	public void atualizar(Usuario usuario){
		ContentValues valores = new ContentValues();
		valores.put("nome", usuario.getNome());
		valores.put("email", usuario.getEmail());
		valores.put("telefone", usuario.getTelefone());
		valores.put("data", usuario.getData());
		valores.put("hora", usuario.getHora());
		valores.put("servico", usuario.getServico());
		valores.put("situacao", "pendente");
		
		bd.update("barbearia", valores, "_id = ?", new String[]{""+usuario.getId()});
	}

	public void atualizarStatus(Usuario usuario){
		ContentValues valores = new ContentValues();
		valores.put("nome", usuario.getNome());
		valores.put("email", usuario.getEmail());
		valores.put("telefone", usuario.getTelefone());
		valores.put("data", usuario.getData());
		valores.put("hora", usuario.getHora());
		valores.put("servico", usuario.getServico());
		valores.put("situacao", "paga");

		bd.update("barbearia", valores, "_id = ?", new String[]{""+usuario.getId()});
	}
	
	
	public void deletar(Usuario usuario){
		bd.delete("barbearia", "_id = "+usuario.getId(), null);
	}
	
	
	public List<Usuario> buscar(){
		List<Usuario> list = new ArrayList<Usuario>();
		String[] colunas1 = new String[]{"_id", "nome", "email" , "telefone","data","hora","servico"};
		
		Cursor cursor1 = bd.query("barbearia", colunas1, "situacao = ?", new String[]{"pendente"}, null, null, "nome ASC");
		
		if(cursor1.getCount() > 0){
			cursor1.moveToFirst();
			
			do{
				
				Usuario u = new Usuario();
				u.setId(cursor1.getLong(0));
				u.setNome(cursor1.getString(1));
				u.setEmail(cursor1.getString(2));
				u.setTelefone(cursor1.getString(3));
				u.setData(cursor1.getString(4));
				u.setHora(cursor1.getString(5));
				u.setServico(cursor1.getString(6));
				list.add(u);
				
			}while(cursor1.moveToNext());
		}
		
		return(list);
	}

	public List<Usuario> buscarPaga(){
		List<Usuario> list1 = new ArrayList<Usuario>();
		String[] colunas = new String[]{"_id", "nome", "email" , "telefone","data","hora","servico"};

		Cursor cursor = bd.query("barbearia", colunas, "situacao = ?", new String[]{"paga"}, null, null, "nome ASC");

		if(cursor.getCount() > 0){
			cursor.moveToFirst();

			do{

				Usuario us = new Usuario();
				us.setId(cursor.getLong(0));
				us.setNome(cursor.getString(1));
				us.setEmail(cursor.getString(2));
				us.setTelefone(cursor.getString(3));
				us.setData(cursor.getString(4));
				us.setHora(cursor.getString(5));
				us.setServico(cursor.getString(6));
				list1.add(us);

			}while(cursor.moveToNext());
		}

		return(list1);
	}
}
