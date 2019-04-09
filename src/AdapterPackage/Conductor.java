/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdapterPackage;

import Flyweight.FlyWeight;
import Flyweight.FlyWeightFactory;


/**
 *
 * @author Nikolas
 */
public class Conductor extends Usuario {
    private FlyWeightFactory factory;
    private String Usuario;
    private String Password;
    
    public Conductor(String Usuario, String Password) {
        super(Usuario, Password);
        FlyWeightFactory factory =  new FlyWeightFactory();
    }
    public Conductor() {
        super();
        FlyWeightFactory factory =  new FlyWeightFactory();
    }
   

  
    
    @Override
    public boolean ingresar(String Usuario, String Pass,Usuario r) {
        boolean x = false;
        if (Usuario.compareToIgnoreCase(r.getUsuario()) == 0 && Pass.compareToIgnoreCase(r.getPassword()) == 0) {
           
           x = true;

        }
         

        return x;
    }  

    
    @Override
    public String Permisos() {
        return "LeerPago,Otro permiso";
    }

    public FlyWeightFactory getFactory() {
        return factory;
    }

    public void AñadirPago(FlyWeight i){
   this.factory.AgregarPago(i);
   
   }
}
     
       

