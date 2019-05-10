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
public class IdentificadorDecorator extends Decorator {

    private String identificador;
    
    public IdentificadorDecorator(String identificador, Componente C) {
        super(C);
        this.identificador = identificador;
    }
    
    public IdentificadorDecorator(Componente C) {
        super(C);
    }
    
    public String getIdentificador() {
        return identificador;
    }
    
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String consultarAtributos() {
        return C.consultarAtributos() + "El identificador es " + this.getIdentificador() + ";";
    }

    public void cambiarAtributo(String caracteristica, String nuevo) {
        C.cambiarAtributo(caracteristica, nuevo);
        if (caracteristica.equalsIgnoreCase("identificador")) {
            this.setIdentificador(nuevo);
        }
    }
    
}
