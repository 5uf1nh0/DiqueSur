package com.sufinho.diquesur;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    private final int DURACION_SPLASH = 5000; // 5 segundos
    TextView title;
    TextView loadText;
    ImageView imgPesc;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = (TextView) findViewById(R.id.title);
        loadText = (TextView) findViewById(R.id.tVload);
        imgPesc = (ImageView) findViewById(R.id.imageView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.getProgressDrawable().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
        progressBar.setBackgroundColor(Color.BLACK);
        progressBar.setProgress(0);

        CargaDatos ATCargaDatos = new CargaDatos(this);
        ATCargaDatos.execute();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                // Cuando cargue la progressBar, pasamos a la actividad login de la aplicación
                //Crear actividad nueva para mostrar la HomeActivity donde apareceran los productos
                // mas destacados con el precio y el Navigation Drawer con el menu lateral izqdo. con
                // las opciones de Inicio, Catalogo, Pedidos, Contacto, Perfil, Acerca de DS
                Intent intent = new Intent(MainActivity.this, NavigationMenu.class);
                startActivity(intent);
                finish();
            }

            ;
        }, DURACION_SPLASH);

    }


    //--> AsyncTask
    class CargaDatos extends AsyncTask<Void, Integer, Void> {

        Context mContext;

        CargaDatos(Context context) {
            mContext = context;
        }

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Void doInBackground(Void... params) {

            publishProgress(0);

            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(50);
                    publishProgress(i + 1);
                    if (isCancelled())
                        break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... value) {
            int progreso = value[0].intValue();
            loadText.setText("Cargando datos..." + progreso + " %");
            progressBar.setProgress(progreso);
        }

        @Override
        protected void onPostExecute(Void result) {

        }

        @Override
        protected void onCancelled() {
            Toast.makeText(MainActivity.this, "Tarea cancelada!",
                    Toast.LENGTH_SHORT).show();
        }

    }// fin asynctask
}