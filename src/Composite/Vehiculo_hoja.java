/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

/**
 *
 * @author Nikolas
 */
public class Vehiculo_hoja implements interfaceGrupo {
    private String Nombre;
    private String tipo;
    private String placa;
    private int capacidad;
    private String referencia; 
    
    public Vehiculo_hoja (String Nombre, String tipo,String placa,int capacidad,String referencia){
  this.tipo=tipo;
  this.placa=placa;
  this.capacidad=capacidad;
  this.referencia=referencia;  
  this.Nombre = Nombre;
    }
    
    public Vehiculo_hoja(){
    };

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo, String Nombre) {
        this.tipo = tipo;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public void setPlaca(String placa, String Nombre) {
        this.placa = placa;
    }

    @Override
    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public void setCapacidad(int capacidad, String Nombre) {
        this.capacidad = capacidad;
    }

    @Override
    public String getReferencia() {
        return referencia;
    }

    @Override
    public void setReferencia(String referencia, String Nombre) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return this.Nombre;
    }

    @Override
    public String toString() {
        return "Vehiculo_hoja " + "Nombre=" + Nombre;
    }
         
    
}
