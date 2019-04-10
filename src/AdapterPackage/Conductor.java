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
    private String tipo = "Conductor";

    public Conductor(String Usuario, String Password) {
        super(Usuario, Password);
        FlyWeightFactory factory = new FlyWeightFactory();
    }

    public Conductor() {
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
        return this.tipo;
    }

    @Override
    public String Permisos() {
        return "LeerPago,CrearRuta,ModificarRuta,EliminarRuta,VerRuta,VerHorario,CerrarSesión,AñadirTarjetaCredito,AñadirTarjetaDebito";
    }

    public FlyWeightFactory getFactory() {
        return factory;
    }

    public void AñadirPago(FlyWeight i) {
        this.factory.AgregarPago(i);

    }

    @Override
    public String getPago(int id) {
        return this.factory.LeerPagoEoC(id);
    }

    @Override
    public String getPagos(String nombreC) {
         return this.factory.toStringPagosConductor(nombreC);
    }
}
