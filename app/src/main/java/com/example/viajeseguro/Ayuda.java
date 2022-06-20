package com.example.viajeseguro;

public class Ayuda {
    private String nombre;
    private String asunto;
    private String peticion;

    public Ayuda(String nombre, String asunto, String peticion) {
        this.nombre = nombre;
        this.asunto = asunto;
        this.peticion = peticion;
    }

    public Ayuda() {
        this.nombre = "none";
        this.asunto = "none";
        this.peticion = "none";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }
}
