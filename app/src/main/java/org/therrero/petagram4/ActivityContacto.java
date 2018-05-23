package org.therrero.petagram4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityContacto extends AppCompatActivity {
    public TextView nombre;
    public TextView correo;
    public TextView mensaje;
    public Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        nombre = findViewById(R.id.campo_nombre);
        correo = findViewById(R.id.campo_correo);
        mensaje = findViewById(R.id.campo_mensaje);
        enviar = findViewById(R.id.boton_aceptar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        android.support.v7.widget.Toolbar miActionBar2 = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(miActionBar2);
    }
    public void onClickBack(View view) {
        onBackPressed();
    }

    private void sendEmail() {
        //Getting content for email
        String email = correo.getText().toString().trim();
        String subject = nombre.getText().toString().trim();
        String message = mensaje.getText().toString().trim();

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}
