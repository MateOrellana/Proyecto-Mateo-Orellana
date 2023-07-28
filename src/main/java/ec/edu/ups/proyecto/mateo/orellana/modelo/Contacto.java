/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyecto.mateo.orellana.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author mateo
 */
public class Contacto {
    private String nombre;
    private String telefono;
    private Collection<String> correos;
    private Map<String, String> redesSociales;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correos = new ArrayList<>();
        this.redesSociales = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Collection<String> getCorreos() {
        return correos;
    }

    public void setCorreos(Collection<String> correos) {
        this.correos = correos;
    }

    public Map<String, String> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(Map<String, String> redesSociales) {
        this.redesSociales = redesSociales;
    }
    
    public void agregarCorreo(String correo) {
        correos.add(correo);
    }

    public void agregarRedSocial(String redSocial, String url) {
        redesSociales.put(redSocial, url);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Teléfono: ").append(telefono).append("\n");
        sb.append("Correos: ").append(correos).append("\n");
        sb.append("Redes Sociales: ").append(redesSociales).append("\n");
        return sb.toString();
    }
}
