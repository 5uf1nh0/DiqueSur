package com.sufinho.diquesur;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ActividadDetalle extends AppCompatActivity {

    public static final String EXTRA_PARAM_ID = "com.sufinho.diquesur.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private Productos itemDetallado;
    private ImageView imagenExtendida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_detalle);
        usarToolbar();

        // Obtener el producto con el identificador establecido en la actividad principal
        itemDetallado = Productos.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));
        imagenExtendida = (ImageView) findViewById(R.id.imagen_pescado);

        cargarImagenExtendida();
    }

    private void cargarImagenExtendida() {
        Glide.with(imagenExtendida.getContext())
                .load(itemDetallado.getImagen())
                .into(imagenExtendida);
    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
