/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composite;

/**
 *
 * @author Valentina
 */
public interface Transporte {

    public String nombre = "";

    public String getNombre();

    public void setNombre(String nombre);

    public String getTipo();

    public String getPlaca();

    public int getCantidadPuesto();

    public String getMarca();

    public String getAno();

    public String getReferencia();

    public String ConsultarNombre(String nombre);  
}
