package com.example.dourado_dtona.barbearia40;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class UsuarioAdapter1 extends BaseAdapter {
    private Context context;
    private List<Usuario> list;

    public UsuarioAdapter1(Context context, List<Usuario> list){
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
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.activity_lista_paga, null);

        TextView tv = (TextView) layout.findViewById(R.id.listap);
        TextView tv1 = (TextView) layout.findViewById(R.id.listap1);
        TextView tv2 = (TextView) layout.findViewById(R.id.listap2);
        TextView tv3 = (TextView) layout.findViewById(R.id.listap3);
        TextView tv4 = (TextView) layout.findViewById(R.id.listap4);
        tv.setText("nome: "+list.get(auxPosition).getNome());
        tv1.setText("email: "+list.get(auxPosition).getEmail());
        tv2.setText("telefone: "+list.get(auxPosition).getTelefone());
        tv3.setText("Horário: "+list.get(auxPosition).getHora()+" Dia: "+list.get(auxPosition).getData());
        tv4.setText("Serviço: "+list.get(auxPosition).getServico());


        return layout;
    }

}
