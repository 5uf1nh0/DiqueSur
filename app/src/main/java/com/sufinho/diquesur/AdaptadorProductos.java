package com.sufinho.diquesur;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.sufinho.diquesur.R.id.parent;

/**
 * Created by sufin on 10/05/2017.
 */

public class AdaptadorProductos extends BaseAdapter {
    private Context context;

    public AdaptadorProductos(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Productos.ITEMS.length;
    }

    @Override
    public Productos getItem(int position) {
        return Productos.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {return getItem(position).getId();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grid_item, parent, false);
        }

        ImageView imagen = (ImageView) convertView.findViewById(R.id.imagen_pescado);
        TextView nombre = (TextView) convertView.findViewById(R.id.nombre_pescado);
        TextView precio = (TextView) convertView.findViewById(R.id.precio_pescado);

        final Productos item = getItem(position);
        Glide.with(imagen.getContext())
                    .load(item.getImagen())
                    .into(imagen);

        nombre.setText(item.getNombre()+" ("+item.getCategoria()+")");
        precio.setText("Precio: "+item.getPrecio()+" €/Kg.");

        return convertView;
    }
}
