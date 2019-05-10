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
public class DescripcionDecorator extends Decorator {
    private String descripcion;

    public DescripcionDecorator(String descripcion, Componente C) {
        super(C);
        this.descripcion = descripcion;
    }

    public DescripcionDecorator(Componente C) {
        super(C);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     public String consultarAtributos() {
        return C.consultarAtributos()+"La descripción es "+this.getDescripcion()+";";
    }
       public void cambiarAtributo(String caracteristica, String nuevo) {
       C.cambiarAtributo(caracteristica, nuevo);
           if (caracteristica.equalsIgnoreCase("descripcion")){
            this.setDescripcion(nuevo);
        }
    }
}
