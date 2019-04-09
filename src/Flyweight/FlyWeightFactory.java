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
    
}
