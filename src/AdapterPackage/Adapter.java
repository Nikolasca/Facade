/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdapterPackage;

import javax.swing.JOptionPane;

/**
 *
 * @author Nikolas
 */
public class Adapter extends Usuario{
 
    private Administrador admin;

    public Adapter(String Usuario, String Password) {
        super(Usuario, Password);
        this.admin = new Administrador();
    }
    public Adapter(){
        super();
        this.admin = new Administrador();
    }

   
    @Override
 
    public boolean ingresar(String Usuario, String Pass,  Usuario r) {

              return admin.Ingresarlalalala(Usuario, Pass, r);
    }


    public String gettipoUsuario() {
        return  this.admin.tomatuusuario(); 
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    
    @Override
    public String Permisos() {
        return "Modificar_ConceptoPago,CrearReserva,LeerReserva,ModificarLugarReserva,LeerPago,CrearPago";
    }
    
}
