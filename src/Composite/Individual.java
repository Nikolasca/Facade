/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

import Decorator.Componente;

/**
 *
 * @author Valentina
 */
public class Individual implements Transporte, Componente {

    private String nombre;
    private String tipo;
    private String placa;
    private int cantidadpuestos;
    private String marca;
    private String ano;
    private String referencia;

    public Individual(String nombre, String tipo, String placa, int cantidadpuestos, String marca, String ano, String referencia) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.placa = placa;
        this.cantidadpuestos = cantidadpuestos;
        this.marca = marca;
        this.ano = ano;
        this.referencia = referencia;
    }

    public String getNombre() {
        return this.nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public int getCantidadPuesto() {
        return this.cantidadpuestos;
    }

    public void setCantidadPuesto(int cantidadpuesto) {
        this.cantidadpuestos = cantidadpuesto;
    }

    @Override
    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getAno() {
        return this.ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String ConsultarNombre(String nombre) {
        String informacion = "Nombre: " + this.getNombre() + " - Placa: " + this.getPlaca() + " - Tipo: " + this.getTipo() + " - Marca: " + this.getMarca()
                + " - Referencia: " + this.getReferencia() + " - Año: " + this.getAno() + " - Cantidad de puestos: " + this.getCantidadPuesto();
        return informacion;
    }
    public String consultarAtributos() {
        return "El nombre es " +this.getNombre()+", la placa es "+this.getPlaca()+", el tipo es "+this.getTipo()+", la marca es "+this.getMarca()+", la referencia es "+this.getReferencia()+", el año es "+this.getAno()+", la cantidad de puestos es de "+this.getCantidadPuesto()+", ";
    }

    public void cambiarAtributo(String caracteristica, String nuevo) {
        if (caracteristica.equalsIgnoreCase("tipo")){
            this.setTipo(nuevo);
        }
        if (caracteristica.equalsIgnoreCase("nombre")){
            this.setNombre(nuevo);
        }
        if (caracteristica.equalsIgnoreCase("cantidadPuestos")){
            this.setCantidadPuesto(Integer.parseInt(nuevo));
        }
    }
}
