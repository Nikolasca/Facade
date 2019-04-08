/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import java.util.ArrayList;
import taller.facade.Facade;

/**
 *
 * @author Pedro de Jesús
 */
public class Proxy {
     //MostrarMenu
    //MandarTodo
    
    private Facade facade;
    private ArrayList<String> nombreUsuario = new ArrayList<>();
    private ArrayList<String> paseUsuario = new ArrayList<>();

    public Proxy(Facade x) {
        this.facade = x;
    }

    public void crearCopia(String nombre, String pass){
        nombreUsuario.add(nombre);
        paseUsuario.add(pass);
    }
    public boolean validarUsuatio(String nombreU, String passwordU) {
        boolean ingreso = false;
        int encontrado=0;
        for(int i=0;i<nombreUsuario.size();i++){
            if(nombreUsuario.get(i).equalsIgnoreCase(nombreU)&&paseUsuario.get(i).equalsIgnoreCase(passwordU)){
                encontrado+=1;
            }
        }
        if(encontrado>0){
            ingreso=true;
            facade=new Facade();
        }
        return ingreso;
    }
public void crearUsuario(String nombre,String pass, String tipo){
        facade.Crear_Usuario(nombre, pass, tipo);
    }
    public void llamarMetodoGeneral(String informacion) throws NoSuchMethodException {
        String[] info = informacion.split(",");
        String accion = info[0];
        String nombreU = info[1];
        String passU = info[2];
        String para = info[3];
        facade.Acceso(accion, nombreU, passU, para);
    }
}
