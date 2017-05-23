package com.example.dourado_dtona.barbearia40;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email;
    EditText senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText)findViewById(R.id.email);
        senha = (EditText)findViewById(R.id.senha);
    }

    public void btnLogar(View v){

        //Toast.makeText(this, "Login: "+ email.getText() + " Senha: "+ senha.getText() +" ;",Toast.LENGTH_LONG).show();
        //TODO Verifica se os campos foram preenchidos;
        if (email.getText().toString().trim().isEmpty()){
            email.setError("Preencha este campo");
            //TODO emite mensagem de erro no campo email quando nao for preenchido
        }
        else if(senha.getText().toString().trim().isEmpty()){
            senha.setError("Preencha este campo");
            //TODO emite mensagem de erro no campo senha quando nao for preenchido
        }else {
            verifica();
        }
    }

    private void verifica() {
        //TODO Comparação dos campos preenchidos e o e-mail e senha cadastrados
        if(email.getText().toString().equals("adm") && senha.getText().toString().equals("luvithi")) { //foi
            Intent intent = new Intent(this, com.example.dourado_dtona.barbearia40.Addhorario.class);
            startActivity(intent);
        }
        else{
            Context contexto = getApplicationContext();
            String texto = "Email/Senha incorreto";
            int duracao = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(contexto, texto,duracao);
            toast.show();
        }
    }


    public void txtEsqueciSenha(View v){
        Intent intent = new Intent(this, com.example.dourado_dtona.barbearia40.esqueciSenha.class);
        startActivity(intent);
    }
}
