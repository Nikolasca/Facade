/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.facade;

import AdapterPackage.Adapter;
import AdapterPackage.Conductor;
import AdapterPackage.Usuario;

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
     Facade f = new Facade();
      Usuario user = new Adapter("Hola","123");
     f.Acceso("CrearReserva", user,"reserva1-123");
     f.Acceso("LeerReserva", user,"123");
    }
    
}
