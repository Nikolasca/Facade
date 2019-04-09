/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Flyweight;

import java.util.ArrayList;

/**
 *
 * @author Valentina
 */
public class FlyWeightFactory {
    private ArrayList<FlyWeight> Fly = new ArrayList<>();

    public FlyWeightFactory() {
    }

    public void CrearPagoEfectivo(int id, String nombrePasajero, String nombreConductor, float monto, String otros) {
        FlyWeight f = new PagoEfectivo(id, nombrePasajero, nombreConductor, monto, otros);
        this.Fly.add(f);
    }

    public void CrearPagoTarjeta(int id, String nombrePasajero, String nombreConductor, float monto, String otros) {
        FlyWeight f = new PagoTarjeta(id, nombrePasajero, nombreConductor, monto, otros);
        this.Fly.add(f);
    }

    public String verSaldosFavor(String nombreU) {
        String favor = "";

        
        
        
        return favor;
    }

    public String verSaldosPagos(String nombreU) {
        String pagado = "";

        return pagado;
    }
    public void AgregarPago(FlyWeight i){
        Fly.add(i);
    
    }

    public ArrayList<FlyWeight> getFly() {
        return Fly;
    }

    public void setFly(ArrayList<FlyWeight> Fly) {
        this.Fly = Fly;
    }
    public FlyWeight Getpago(int id) {
           FlyWeight s = null;
        for (int i = 0; i < Fly.size(); i++) {
            if (id == Fly.get(i).getId())
            {
                s = Fly.get(i);
            }
        }
        return s;
    }
    
    public void EliminarPago(FlyWeight i){
        Fly.remove(i);
    
    }
    public void ModificarPago(int i, String NuevoValor, String NuevoValor2, String NuevoValor3){
        Fly.get(i).setOtros(NuevoValor, NuevoValor2, NuevoValor3);
    }
}
