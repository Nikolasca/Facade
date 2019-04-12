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
   f.Acceso("crearAgrupacion", "Hola", "123", "Particular");
   f.Acceso("crearAgrupacion", "Hola", "123", "Publico");
   f.Acceso("EliminarElemento", "Hola", "123","Carro2");
   
   System.out.println(f.Acceso("VerTodos", "hola","123","Particular"));
    
     //f.Acceso("LeerReserva", user,"123");
    }
    
}
