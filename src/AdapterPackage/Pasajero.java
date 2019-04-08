/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdapterPackage;

/**
 *
 * @author Nikolas
 */
public class Pasajero extends Usuario {


    public Pasajero(String Usuario, String Password) {
        super(Usuario, Password);
    }
     public Pasajero() {
        super();
    }
    
    

    @Override
    public boolean ingresar(String Usuario, String Pass, Usuario r) {
        boolean x = false;
        if (Usuario.compareToIgnoreCase(r.getUsuario()) == 0 && Pass.compareToIgnoreCase(r.getPassword()) == 0) {
           
            x = true;

        } 
return x;
    }  




    @Override
    public String getTipo_Usuario() {
       return this.getTipo_Usuario(); 
    }

    @Override
    public String Permisos() {
        return "CrearReserva,CrearPago,";
    }

  
   

   

}