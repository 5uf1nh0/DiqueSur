package com.sufinho.diquesur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by sufin on 30/11/2016.
 */

public class BD_Productos extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "BD_Productos.db";
    private static final String sentencia = "CREATE TABLE Productos (idProducto INTEGER PRIMARY KEY AUTO_INCREMENT, nombre VARCHAR(100), " +
            "nomCient VARCHAR(100), stock NUMERIC, precio DOUBLE, origen VARCHAR(255),categoria NUMERIC, imagen VARCHAR(100));";
    private static final ArrayList<Productos> listaProductos =new ArrayList<Productos>();
    /* METODOS OBLIGATORIOS PARA SQLITEOPENHELPER */

    public BD_Productos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sentencia);
        listaProductos.add(new Productos("Rape","Gallo",80,12.50,"Marruecos","Pescados",R.drawable.rape));
        db.beginTransaction();

        try{
            ContentValues values=new ContentValues();
            for(int i = 0; i< listaProductos.size(); i++){
                values.put("nombre", listaProductos.get(i).getNombre());
                values.put("nomCient", listaProductos.get(i).getNomCient());
                values.put("stock", listaProductos.get(i).getStock());
                values.put("precio", listaProductos.get(i).getPrecio());
                values.put("origen", listaProductos.get(i).getOrigen());
                values.put("imagen", listaProductos.get(i).getImagen());
                db.insert("Productos",null,values);
            }
            db.setTransactionSuccessful();
        }finally {
            db.endTransaction();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Contactos");
        onCreate(db);
    }

    public long insertar(Productos p){

        long nreg_afectados=-1;

        SQLiteDatabase db=getWritableDatabase();

        if(db!=null){
            ContentValues valores= new ContentValues();
            //valores.put("idContacto",c.getId());
            valores.put("nombre",p.getNombre());
            valores.put("nomCient",p.getNomCient());
            valores.put("stock",p.getStock());
            valores.put("precio",p.getPrecio());
            valores.put("origen",p.getOrigen());
            valores.put("imagen",p.getImagen());

            db.insert("Productos",null,valores);
        }
        db.close();
        return nreg_afectados;
    }


    public ArrayList<Productos> listado() {

        Productos producto;

        SQLiteDatabase db = getReadableDatabase();

        ArrayList<Productos> lista_productos = new ArrayList<Productos>();

        if (db != null) {
            String[] camposContactos = {"idProducto", "nombre", "nomCient", "stock","precio", "categoria", "imagen"};
            Cursor c = db.query("Contactos", camposContactos, null, null, null, null, null, null);

            if (c.moveToFirst()) {
                do {
                    producto = new Productos(c.getString(1), c.getString(2), c.getInt(3), c.getDouble(4), c.getString(5), c.getInt(6));
                    lista_productos.add(producto);
                }while(c.moveToNext());
                System.out.println("Hay "+c.getCount()+" registros en el cursor.");
            }
            c.close();
        }

        System.out.println("Hay "+lista_productos.size()+" productos en la lista.");
        for(int i=0;i<lista_productos.size();i++)
            System.out.println("Elemento "+i+": "+lista_productos.get(i).getNombre());
        db.close();
        return lista_productos;
    }
}
