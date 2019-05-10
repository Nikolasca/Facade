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
public interface Componente {
    public String consultarAtributos();
    public void cambiarAtributo(String caracteristica, String nuevo);
}
