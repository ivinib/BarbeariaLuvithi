package com.example.dourado_dtona.barbearia40;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
	private static final String NOME_BD = "barbearia";
	private static final int VERSAO_BD = 8;
	
	
	public BDCore(Context ctx){
		super(ctx, NOME_BD, null, VERSAO_BD);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL("create table barbearia(_id integer primary key autoincrement, nome text not null, email text not null, telefone text not null,data text not null,hora text not null, servico text not null, situacao text not null);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
		bd.execSQL("drop table barbearia;");
		onCreate(bd);
	}

}
