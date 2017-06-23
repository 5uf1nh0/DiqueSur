package com.sufinho.diquesur;

/**
 * Created by sufin on 01/05/2017.
 */

public class Productos {
    protected int idProducto;
    protected String categoria;
    protected String nombre;
    protected String nomCient;
    protected int stock;
    protected double precio;
    protected String origen;
    protected int imagen;

    public Productos(String nombre, String nomCient, int stock, double precio, String origen, String categoria, int imagen) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.nomCient = nomCient;
        this.stock = stock;
        this.precio = precio;
        this.origen = origen;
        this.imagen = imagen;
    }

    public Productos(String string, String cString, int cInt, double aDouble, String s, int i) {
        this.categoria = "Prueba";
        this.nombre = "DiqueSur";
        this.nomCient = "Pescaderia";
        this.stock = 0;
        this.precio = 0.0;
        this.origen = "España";
        this.imagen = R.drawable.dique_pink;
    }

    public static Productos[] ITEMS = {

            new Productos("Almeja","Bivalbo",100,8.00,"Marruecos","Marisco", R.drawable.almeja),
            new Productos("Caballa","Caballa",100,2.50,"Marruecos","Pescado", R.drawable.caballa),
            new Productos("Atún","Atún",100,18.00,"Marruecos","Pescado", R.drawable.atun),
            new Productos("Calamar","Cefalopodo",100,14.00,"Marruecos","Marisco", R.drawable.calamar),
            new Productos("Bacalao","Bacalao",100,12.00,"España/Galicia","Pescado", R.drawable.bacalao),
            new Productos("Boquerón","Boqueron",100,5.00,"Marruecos","Pescado", R.drawable.boquerones),
            new Productos("Centollo","Crustaceo-Decadopodo",100,7.00,"España/Galicia","Marisco", R.drawable.centollo),
            new Productos("Cabracho","Gallineta",100,8.00,"Marruecos","Pescado", R.drawable.cabracho),
            new Productos("Dorada","Dorada",100,6.00,"Marruecos","Pescado", R.drawable.dorada),
            new Productos("Gamba","Crustaceo-Decadopodo",100,35.00,"Marruecos","Marisco", R.drawable.gamba),
    };

    public static Productos getItem(int id) {
        for (Productos item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public int getId(){return nombre.hashCode();}

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNomCient() {
        return nomCient;
    }

    public void setNomCient(String nomCient) {
        this.nomCient = nomCient;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
