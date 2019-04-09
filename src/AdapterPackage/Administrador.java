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
public class Administrador {
    private String Usuario;
    private String Password;
    private String TipoUsuario;
    public boolean Ingresarlalalala(String Usuario, String Pass, Usuario r) {
       boolean x = false;
        if (Usuario.compareToIgnoreCase(r.getUsuario()) == 0 && Pass.compareToIgnoreCase(r.getPassword()) == 0) {
            
            x = true;

        }
        
        return x;
    }  //To change body o
    
    public String tomatuusuario() {
        return Password;
    }
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }
    
            
}
