/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Decorator;

import java.util.ArrayList;

/**
 *
 * @author Pedro de Jesús
 */
public abstract class Decorator implements Componente{

    protected Componente C;

    public Decorator(Componente C) {
        this.C = C;
    }
    
    public String consultarAtributos() {
        return C.consultarAtributos();
    }
    public void cambiarAtributo(String caracteristica, String nuevo) {
     C.cambiarAtributo(caracteristica, nuevo);
        }
    }
    

