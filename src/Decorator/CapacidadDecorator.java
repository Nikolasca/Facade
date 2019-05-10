/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

/**
 *
 * @author Pedro de Jesús
 */
public class CapacidadDecorator extends Decorator {
    int capacidad;
    public CapacidadDecorator(Componente C) {
        super(C);
    }

    public CapacidadDecorator(int capacidad, Componente C) {
        super(C);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public String consultarAtributos() {
        return C.consultarAtributos()+"La capacidad es "+this.getCapacidad()+";";
    }
     public void cambiarAtributo(String caracteristica, String nuevo) {
        C.cambiarAtributo(caracteristica, nuevo);
          if (caracteristica.equalsIgnoreCase("capacidad")){
            this.setCapacidad(Integer.parseInt(nuevo));
        }
    }
}
