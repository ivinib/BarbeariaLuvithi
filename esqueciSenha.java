package com.example.dourado_dtona.barbearia40;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class esqueciSenha extends AppCompatActivity {
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueci_senha);
        email = (EditText)findViewById(R.id.email);
    }

    public void voltarLogin(View v){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnEsqueciSenha(View v) {

        if (email.getText().toString().trim().isEmpty()) {
            email.setError("Campo obrigatório");
            //TODO emite mensagem de erro no campo email quando nao for preenchido
        } else {
            Context contexto = getApplicationContext();
            String texto = "E-mail digitado: " + email.getText();
            int duracao = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(contexto, texto, duracao);
            toast.show();

          Intent intent = new Intent(Intent.ACTION_SEND);
          intent.setType("message/rfc822");
          intent.putExtra(Intent.EXTRA_EMAIL, new String[]{ email.getText().toString()});
          intent.putExtra(Intent.EXTRA_SUBJECT, "Recuperação de senha");
          intent.putExtra(Intent.EXTRA_TEXT, "Código de recuperação : 8B6C2A");
          if (intent.resolveActivity(getPackageManager()) != null) {
               startActivity(intent);
           }
        }
    }
}
