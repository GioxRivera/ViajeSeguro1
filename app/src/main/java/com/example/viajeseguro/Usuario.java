package com.example.viajeseguro;

public class Usuario {
    private String correo;
    private String contrasena;
    private boolean registrado;

    public Usuario(String correo, String contrasena, boolean registrado) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.registrado = registrado;
    }

    public Usuario() {
        this.correo = "none";
        this.contrasena = "none";
        this.registrado = false;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }
}
