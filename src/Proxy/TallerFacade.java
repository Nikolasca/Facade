/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

import AdapterPackage.Adapter;
import AdapterPackage.Usuario;
import taller.facade.Facade;

/**
 *
 * @author Nikolas
 */
public class TallerFacade {

    /**
     * @param args the command line arguments
     * @throws java.lang.NoSuchMethodException
     */
    public static void main(String[] args) throws NoSuchMethodException {
     Facade f = Facade.getFacade();
   f.Acceso("crearAgrupacion", "Hola", "123", "Particular-1");
   
   f.Acceso("crearAgrupacion", "Hola", "123", "Publico-2");
   f.Acceso("crearAgrupacion", "Hola", "123", "Otro-3");
   f.Acceso("EliminarElemento", "Hola", "123","2");
   System.out.println(f.Acceso("VerTodos", "hola","123",""));
    
     //f.Acceso("LeerReserva", user,"123");
    }
    
}
