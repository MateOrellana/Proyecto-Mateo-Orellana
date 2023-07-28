/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.proyecto.mateo.orellana.controlador;

import ec.edu.ups.proyecto.mateo.orellana.modelo.Contacto;
import ec.edu.ups.proyecto.mateo.orellana.modelo.Nodo;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mateo
 */
public class ArbolContactos {
    private Nodo raiz;

    public ArbolContactos() {
        this.raiz = null;
    }

    public void agregarContacto(Contacto contacto) {
        raiz = agregarContactoRec(raiz, contacto);
    }

    private Nodo agregarContactoRec(Nodo nodo, Contacto contacto) {
        if (nodo == null) {
            return new Nodo(contacto);
        }

        String nombreActual = nodo.getContacto().getNombre();
        String nuevoNombre = contacto.getNombre();

        int comparacion = nuevoNombre.compareTo(nombreActual);

        if (comparacion < 0) {
            nodo.setIzquierdo(agregarContactoRec(nodo.getIzquierdo(), contacto));
        } else if (comparacion > 0) {
            nodo.setDerecho(agregarContactoRec(nodo.getDerecho(), contacto));
        }

        return nodo;
    }

    public Contacto buscarContacto(String nombre) {
        Nodo nodo = buscarContactoRec(raiz, nombre);
        if (nodo != null) {
            return nodo.getContacto();
        }
        return null;
    }

    private Nodo buscarContactoRec(Nodo nodo, String nombre) {
        if (nodo == null || nodo.getContacto().getNombre().equals(nombre)) {
            return nodo;
        }

        int comparacion = nombre.compareTo(nodo.getContacto().getNombre());

        if (comparacion < 0) {
            return buscarContactoRec(nodo.getIzquierdo(), nombre);
        } else {
            return buscarContactoRec(nodo.getDerecho(), nombre);
        }
    }

    public void eliminarContacto(String nombre) {
        raiz = eliminarContactoRec(raiz, nombre);
    }

    private Nodo eliminarContactoRec(Nodo nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        int comparacion = nombre.compareTo(nodo.getContacto().getNombre());

        if (comparacion < 0) {
            nodo.setIzquierdo(eliminarContactoRec(nodo.getIzquierdo(), nombre));
        } else if (comparacion > 0) {
            nodo.setDerecho(eliminarContactoRec(nodo.getDerecho(), nombre));
        } else {
            if (nodo.getIzquierdo() == null) {
                return nodo.getDerecho();
            } else if (nodo.getDerecho() == null) {
                return nodo.getIzquierdo();
            }

            Nodo sucesor = obtenerSucesor(nodo.getDerecho());
            nodo.setContacto(sucesor.getContacto());
            nodo.setDerecho(eliminarContactoRec(nodo.getDerecho(), sucesor.getContacto().getNombre()));
        }

        return nodo;
    }

    private Nodo obtenerSucesor(Nodo nodo) {
        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }

    public void agregarCorreo(String nombre, String correo) {
        Nodo nodo = buscarContactoRec(raiz, nombre);
        if (nodo != null) {
            nodo.getContacto().agregarCorreo(correo);
        }
    }

    public void agregarRedSocial(String nombre, String redSocial, String url) {
        Nodo nodo = buscarContactoRec(raiz, nombre);
        if (nodo != null) {
            nodo.getContacto().agregarRedSocial(redSocial, url);
        }
    }

    public void recorridoPreorder() {
        recorridoPreorderRec(raiz);
    }

    private void recorridoPreorderRec(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.getContacto());
            recorridoPreorderRec(nodo.getIzquierdo());
            recorridoPreorderRec(nodo.getDerecho());
        }
    }

    public void recorridoInorder() {
        recorridoInorderRec(raiz);
    }

    private void recorridoInorderRec(Nodo nodo) {
        if (nodo != null) {
            recorridoInorderRec(nodo.getIzquierdo());
            System.out.println(nodo.getContacto());
            recorridoInorderRec(nodo.getDerecho());
        }
    }

    public void recorridoPostorder() {
        recorridoPostorderRec(raiz);
    }

    private void recorridoPostorderRec(Nodo nodo) {
        if (nodo != null) {
            recorridoPostorderRec(nodo.getIzquierdo());
            recorridoPostorderRec(nodo.getDerecho());
            System.out.println(nodo.getContacto());
        }
    }

    public void recorridoAchura() {
        Queue<Nodo> cola = new LinkedList<>();
        if (raiz != null) {
            cola.add(raiz);
        }

        while (!cola.isEmpty()) {
            Nodo nodo = cola.poll();
            System.out.println(nodo.getContacto());

            if (nodo.getIzquierdo() != null) {
                cola.add(nodo.getIzquierdo());
            }
            if (nodo.getDerecho() != null) {
                cola.add(nodo.getDerecho());
            }
        }
    }

    public int obtenerNumeroContactos() {
        return obtenerNumeroContactosRec(raiz);
    }

    private int obtenerNumeroContactosRec(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + obtenerNumeroContactosRec(nodo.getIzquierdo()) + obtenerNumeroContactosRec(nodo.getDerecho());
    }

    public int obtenerNumeroNiveles() {
        return obtenerNumeroNivelesRec(raiz);
    }

    private int obtenerNumeroNivelesRec(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + Math.max(obtenerNumeroNivelesRec(nodo.getIzquierdo()), obtenerNumeroNivelesRec(nodo.getDerecho()));
    }
}
