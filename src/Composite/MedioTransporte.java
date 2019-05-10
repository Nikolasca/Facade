/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

import java.util.ArrayList;

/**
 *
 * @author Valentina
 */
public class MedioTransporte implements Transporte {

    private String nombre;
    ArrayList<Transporte> Grupo;

    public MedioTransporte(String nombre) {
        this.nombre = nombre;
        this.Grupo = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String buscarNombre() {
        String nom = "";
        for (Transporte t : Grupo) {
            nom += t.getNombre() + "\n";
        }
        return this.nombre + "\n" + nom;
    }

    @Override
    public String getTipo() {
        String tipo = "";
        for (Transporte t : Grupo) {
            tipo += t.getTipo() + "\n";
        }
        return this.nombre + "\n" + tipo;
    }

    @Override
    public String getPlaca() {
        String placa = "";
        for (Transporte t : Grupo) {
            placa += t.getPlaca() + "\n";
        }
        return this.nombre + "\n" + placa;
    }

    @Override
    public int getCantidadPuesto() {
        String cantidadpuestos = "";
        for (Transporte t : Grupo) {
            cantidadpuestos += t.getCantidadPuesto() + "\n";
        }
        return Integer.parseInt(cantidadpuestos);
    }

    @Override
    public String getMarca() {
        String marca = "";
        for (Transporte t : Grupo) {
            marca += t.getMarca() + "\n";
        }
        return this.nombre + "\n" + marca;
    }

    @Override
    public String getAno() {
        String ano = "";
        for (Transporte t : Grupo) {
            ano += t.getAno() + "\n";
        }
        return this.nombre + "\n" + ano;
    }

    @Override
    public String getReferencia() {
        String ref = "";
        for (Transporte t : Grupo) {
            ref += t.getReferencia() + "\n";
        }
        return this.nombre + "\n" + ref;
    }

    public String ConsultarNombre(String nombre) {
        String n = nombre;
        String nom = "";

        for (int i = 0; i < Grupo.size(); i++) {
            System.out.println("1");
            if (Grupo.get(i).getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("2");
                for (int a = i; a <Grupo.size(); a++) {
                    System.out.println("a: " + a);
                    System.out.println("3");
                    System.out.println("get: " + Grupo.get(a).getNombre());
                    nom += Grupo.get(a).ConsultarNombre(Grupo.get(a).getNombre()) + "\n";
                    System.out.println("nom: " + nom);
                }
            }
        }
        return nom;

        /*
        for (Transporte t : Grupo) {
            nom += t.ConsultarNombre("")+ "\n";
        }
        return this.nombre + "\n" + nom;
        
        String placa = "";
        int posicionconsultado = 0;
        for (int i = 0; i < Grupo.size(); i++) {
            if (Grupo.get(i).getNombre().equalsIgnoreCase(nombre)) {
                posicionconsultado = i;
            }
        }
        placa = Grupo.get(posicionconsultado).getNombre();
        return placa;
         */
    }

    public void Crear(Transporte t) {
        Grupo.add(t);
        System.out.println("Creado");
    }

    public void Eliminar(Transporte t) {
        Grupo.remove(t);
    }

    public Transporte CambiarPlaca(String Nombre, String placa) {
        int porcambiar = 0;
        for (int i = 0; i < Grupo.size(); i++) {
            if (Grupo.get(i).getNombre().equalsIgnoreCase(Nombre)) {
                porcambiar = i;
            }
        }
        return Grupo.get(porcambiar);
    }
}
