package com.example.dourado_dtona.barbearia40;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Addhorario extends AppCompatActivity {

    Usuario usuario = new Usuario();
    EditText nome;
    EditText telefone;
    EditText servico;
    EditText hora;
    EditText email;
    EditText data;
    private Button btnNovo;
    private Button btnEdit;

    private long lastBackPressTime = 0;
    private Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addhorario);

        nome = (EditText) findViewById(R.id.nome);
        telefone = (EditText) findViewById(R.id.telefone);
        servico = (EditText) findViewById(R.id.servico);
        email = (EditText) findViewById(R.id.email);
        data = (EditText) findViewById(R.id.data);
        hora = (EditText) findViewById(R.id.hora);
        btnNovo = (Button) findViewById(R.id.btnNovo);
        btnEdit = (Button) findViewById(R.id.btnEdit);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                usuario.setId(bundle.getLong("id"));
                usuario.setNome(bundle.getString("nome"));
                usuario.setEmail(bundle.getString("email"));
                usuario.setTelefone(bundle.getString("telefone"));
                usuario.setData(bundle.getString("data"));
                usuario.setHora(bundle.getString("hora"));
                usuario.setServico(bundle.getString("servico"));

                nome.setText(usuario.getNome());
                email.setText(usuario.getEmail());
                telefone.setText(usuario.getTelefone());
                data.setText(usuario.getData());
                hora.setText(usuario.getHora());
                servico.setText(usuario.getServico());

                btnNovo.setVisibility(View.GONE);
                btnEdit.setVisibility(View.VISIBLE);
            }
        }
    }

    public void Horarios(View v){
        Intent intent = new Intent(this, telaPrincipal.class);
        startActivity(intent);
    }
    public void Pagos(View v){
        Intent intent = new Intent(this, listaPaga.class);
        startActivity(intent);
    }

    public void novoServico(View v){
        if (nome.getText().toString().trim().isEmpty()){
            nome.setError("Preencha este campo");
            //TODO emite mensagem de erro no campo email quando nao for preenchido
        }
        else if(telefone.getText().toString().trim().isEmpty()){
            telefone.setError("Preencha este campo");
            //TODO emite mensagem de erro no campo senha quando nao for preenchido
        }
        else if(servico.getText().toString().trim().isEmpty()){
            servico.setError("Preencha este campo");
            //TODO emite mensagem de erro no campo senha quando nao for preenchido
        }
        else if(hora.getText().toString().trim().isEmpty()){
            hora.setError("Preencha este campo");
            //TODO emite mensagem de erro no campo senha quando nao for preenchido
        }else if(data.getText().toString().trim().isEmpty()){
            data.setError("Preencha este campo");
            //TODO emite mensagem de erro no campo senha quando nao for preenchido
        }else if(email.getText().toString().trim().isEmpty()){
            email.setError("Preencha este campo");
            //TODO emite mensagem de erro no campo senha quando nao for preenchido
        }else {

            usuario.setNome(nome.getText().toString());
            usuario.setEmail(email.getText().toString());
            usuario.setTelefone(telefone.getText().toString());
            usuario.setData(data.getText().toString());
            usuario.setHora(hora.getText().toString());
            usuario.setServico(servico.getText().toString());

            BD bd = new BD(this);
            bd.inserir(usuario);

            Toast.makeText(this, "Horário agendado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    public void editarHorario(View view){
        usuario.setNome(nome.getText().toString());
        usuario.setEmail(email.getText().toString());
        usuario.setTelefone(telefone.getText().toString());
        usuario.setData(data.getText().toString());
        usuario.setHora(hora.getText().toString());
        usuario.setServico(servico.getText().toString());

        BD bd = new BD(this);
        bd.atualizar(usuario);

        Toast.makeText(this, "Horário do(a) \""+usuario.getNome()+"\" atualizado com sucesso.", Toast.LENGTH_SHORT).show();
    }
    public void Sair(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void onBackPressed() {
        if (this.lastBackPressTime < System.currentTimeMillis() - 3000) {
            toast = Toast.makeText(this, "Pressione o Botão Voltar novamente para fechar o Aplicativo.", Toast.LENGTH_LONG);
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

}
