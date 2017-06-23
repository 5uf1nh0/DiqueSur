package com.sufinho.diquesur;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by sufin on 26/05/2017.
 */

public class FragmentoDetalleProducto extends Fragment {
    public static final String ID_ARTICULO = "extra.idArticulo";


    public FragmentoDetalleProducto(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ID_ARTICULO)) {
            // Cargar modelo según el identificador
            //itemDetallado = ModeloArticulos.MAPA_ITEMS.get(getArguments().getString(ID_ARTICULO));

        }
    }
}
