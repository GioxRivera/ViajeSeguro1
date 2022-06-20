package com.example.viajeseguro;

public class reporte {
    private String clasificacion;
    private String usuarior;
    private String descripcion;
    private String fecha;
    private String direccion;
    private String sector;
    private Integer foto;

    public reporte(String clasificacion, String usuarior, String descripcion, String fecha, String direccion, String sector, Integer foto) {
        this.clasificacion = clasificacion;
        this.usuarior = usuarior;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.direccion = direccion;
        this.sector = sector;
        this.foto = foto;
    }

    public reporte() {
        this.clasificacion = "none";
        this.usuarior = "none";
        this.descripcion = "none";
        this.fecha = "none";
        this.direccion = "none";
        this.sector = "none";
        this.foto = 0;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getUsuarior() {
        return usuarior;
    }

    public void setUsuarior(String usuarior) {
        this.usuarior = usuarior;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
