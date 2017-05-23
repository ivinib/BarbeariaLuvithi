package com.example.dourado_dtona.barbearia40;

import java.util.List;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class UsuarioAdapter extends BaseAdapter {
	private Context context;
	private List<Usuario> list;

	public UsuarioAdapter(Context context, List<Usuario> list){
		this.context = context;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0).getId();
	}

	@Override
	public View getView(final int position, View arg1, ViewGroup arg2) {
		final int auxPosition = position;
		
		final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_tela_principal, null);
		
		TextView tv = (TextView) layout.findViewById(R.id.lista);
		TextView tv1 = (TextView) layout.findViewById(R.id.lista1);
		TextView tv2 = (TextView) layout.findViewById(R.id.lista2);
		TextView tv3 = (TextView) layout.findViewById(R.id.lista3);
		TextView tv4 = (TextView) layout.findViewById(R.id.lista4);
		tv.setText("nome: "+list.get(auxPosition).getNome());
		tv1.setText("email: "+list.get(auxPosition).getEmail());
		tv2.setText("telefone: "+list.get(auxPosition).getTelefone());
		tv3.setText("Horário: "+list.get(auxPosition).getHora()+" Dia: "+list.get(auxPosition).getData());
		tv4.setText("Serviço: "+list.get(auxPosition).getServico());
		
		Button editarBt = (Button) layout.findViewById(R.id.editar);
		editarBt.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, Addhorario.class);
				intent.putExtra("nome", list.get(auxPosition).getNome());
				intent.putExtra("email", list.get(auxPosition).getEmail());
				intent.putExtra("telefone", list.get(auxPosition).getTelefone());
				intent.putExtra("data", list.get(auxPosition).getData());
				intent.putExtra("hora", list.get(auxPosition).getHora());
				intent.putExtra("servico", list.get(auxPosition).getServico());
				intent.putExtra("id", list.get(auxPosition).getId());
				context.startActivity(intent);
			}
		});


//		Button emailBt = (Button) layout.findViewById(R.id.enviaEmail);
//		emailBt.setOnClickListener(new Button.OnClickListener(){
//
//
//			@Override
//			public void onClick(View arg0) {
//				Intent intent = new Intent(Intent.ACTION_SEND);
//				intent.setType("message/rfc822");
//				intent.putExtra(Intent.EXTRA_EMAIL, new String[]{list.get(auxPosition).getEmail()});
//				intent.putExtra(Intent.EXTRA_SUBJECT, "Confirmação de horário");
//				intent.putExtra(Intent.EXTRA_TEXT, "Serviço: "+list.get(auxPosition).getServico()+" ás "+list.get(auxPosition).getHora()+" do dia: "+list.get(auxPosition).getData());
//				if (intent.resolveActivity(getPackageManager()) != null) {
//					startActivity(intent);
//				}
//			}
//		});


		Button deletarBt = (Button) layout.findViewById(R.id.deletar);
		deletarBt.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View arg0) {
				//Cria o gerador do AlertDialog
				AlertDialog.Builder builder = new AlertDialog.Builder(context);
				//define o titulo
				builder.setTitle("Exclusão");
				//define a mensagem
				builder.setMessage("Deseja mesmo excluir?");
				//define um botão como positivo
				builder.setPositiveButton("Excluir", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {
						BD bd = new BD(context);
						bd.deletar(list.get(auxPosition));

						layout.setVisibility(View.GONE);
					}
				});
				//define um botão como negativo.
				builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface arg0, int arg1) {

					}
				});
				//cria o AlertDialog
				builder.create();
				//Exibe
				builder.show();
			}
		});

        Button concluirBT = (Button) layout.findViewById(R.id.concluir);
        concluirBT.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                BD bd = new BD(context);
                bd.atualizarStatus(list.get(auxPosition));
            }
        });

		return layout;
	}

}
