package com.google2.google2;


import android.widget.EditText;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;


public class ActivityFormulario extends AppCompatActivity {
    private Button button_mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        button_mapa = (Button)findViewById(R.id.button_mapa);
        button_mapa.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick( View v){
                Intent intent = new Intent(ActivityFormulario.this, google2.class);
                startActivity(intent);
            }
         }
        );
    }
    public void enviar(View view){
        EditText email = (EditText) findViewById(R.id.edt_email);
        EditText nombre = (EditText) findViewById(R.id.edt_nombre);
        EditText comentario = (EditText) findViewById(R.id.edt_comentario);
        String contenido = "Nombre: "+nombre.getText().toString()+"\n"+"Email:"+email.getText().toString()+"\n consulta:\n"+comentario.getText().toString();



        Intent itSend = new Intent(android.content.Intent.ACTION_SEND);


        itSend.setType("plain/text");


        itSend.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{ "consultas@paparelli.com.ar"});
        itSend.putExtra(android.content.Intent.EXTRA_SUBJECT, "consulta");
        itSend.putExtra(android.content.Intent.EXTRA_TEXT, contenido );


        startActivity(itSend);
    }



    /*public void mapa(View view){

        Intent intent = new Intent(ActivityFormulario.this, google2.class);
        startActivity(intent);
    }*/

}

