/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.facade;

import AdapterPackage.Adapter;
import AdapterPackage.Conductor;
import AdapterPackage.Pasajero;
import AdapterPackage.Usuario;
import Flyweight.FlyWeightFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author Nikolas
 */
public class Facade {
    
    PagoGrupo G1 = new PagoGrupo();
    ReservaGrupo G2 = new ReservaGrupo();
    ArrayList<Usuario> componentes = new ArrayList();
    private static Facade facade;
    FlyWeightFactory FF = new FlyWeightFactory();

    public Facade() {
        Usuario user = new Adapter("Hola", "123");
        this.componentes.add(user);
    }
    
    public static Facade getFacade() {
        if (facade == null) {
            facade = new Facade();
        }
        return facade;
    }
    
    public void CrearReserva(String nombre, String id) {
        Reserva reserva = new Reserva(nombre, id);
        G2.AñadirGrupito(reserva);
        
    }
    
    public void AñadirReserva(Reserva r) {
        G2.AñadirGrupito(r);
        
    }
    
    public void EliminarReservaGrupo(Reserva r) {
        G2.EliminarAlGrupito(r);
    }
    
    public void ModificarLugarReserva(String id, String Lugar) {
        G2.ModificarLugar(id, Lugar);
    }
    
    public String LeerReserva(String id) {
        return G2.LeerReserva(id);
    }
    
    public void CrearPago(String pago, String id) {
        Pago pago1 = new Pago(pago, id);
        
    }
    
    public void AñadirPago(Pago r) {
        G1.AñadirGrupito(r);
    }
    
    public void EliminarPago(Pago r) {
        G1.EliminarAlGrupito(r);
    }
    
    public String LeerPago(String id) {
        return G1.LeerPago(id);
    }
    
    public void Modificar_ConceptoPago(String id, String Concepto) {
        G1.ModificarConcepto(id, Concepto);
    }
    
    public void Acceso(String Accion, Usuario user, String Para) throws NoSuchMethodException {
        for (int i = 0; i < this.componentes.size(); i++) {
            if (user.getUsuario().compareTo(componentes.get(i).getUsuario()) == 0 && user.getPassword().compareTo(componentes.get(i).getPassword()) == 0) {
                
                for (Object c : componentes) {
                    
                    Method[] metodos = componentes.get(i).getClass().getMethods();
                    Method[] metodosFacade = Facade.class.getMethods();
                    
                    try {
                        
                        Method methodcall1 = componentes.get(i).getClass().getDeclaredMethod("Permisos");
                        String cadena = (String) methodcall1.invoke(c);
                        String[] parts = cadena.split(",");
                        String[] para = Para.split("-");
                        
                        for (String part : parts) {
                            for (Method metodosFacade1 : metodosFacade) {
                                if (part.contains(metodosFacade1.getName()) && metodosFacade1.getName().contains(Accion)) {
                                    if (Accion.equals("CrearReserva")) {
                                        
                                        CrearReserva(para[0], para[1]);
                                        break;
                                    }
                                } else if (Accion.equals("LeerReserva")) {
                                    LeerReserva(para[0]);
                                    break;
                                    
                                } else if (Accion.equals("ModificarLugarReserva")) {
                                    ModificarLugarReserva(para[0], para[1]);
                                    break;
                                    
                                } else if (Accion.equals("CrearPago")) {
                                    CrearPago(para[0], para[1]);
                                    break;
                                    
                                } else if (Accion.equals("EliminarPago")) {
                                    EliminarPago(G1.ObtenerPago(para[0]));
                                    break;
                                    
                                } else if (Accion.equals("Modificar_ConceptoPago")) {
                                    Modificar_ConceptoPago(para[0], para[1]);
                                    break;
                                    
                                } else if (Accion.equals("LeerPago")) {
                                    LeerPago(para[0]);
                                    break;
                                    
                                }
                            }
                        }
                        
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    
                }
                
            }
            
        }
        
    }
    
    public void Crear_Usuario(String User, String pass, String Tipo) {
        if (Tipo.equals("Pasajero")) {
            Usuario usuario = new Pasajero(User, pass);
            usuario.setTipo_Usuario(Tipo);
            componentes.add(usuario);
            
        } else if (Tipo.equals("Conductor")) {
            Usuario usuario = new Conductor();
            usuario.setTipo_Usuario(Tipo);
            componentes.add(usuario);
        } else if (Tipo.equals("Admministrador")) {
            Usuario usuario = new Adapter();
            usuario.setTipo_Usuario(Tipo);
            componentes.add(usuario);
            
        } else {
            System.out.print("No hizo match tipo");
        }
    }
    
    public void crearCredito() {
        
    }
    
    public void crearEfectivo(int id, String nombrePasajero, String nombreConductor, float monto, String otros) {
        FF.CrearPagoEfectivo(id, nombrePasajero, nombreConductor, monto, otros);
    }
    
    public void crearTransporteIndividial(int id, String nombrePasajero, String nombreConductor, float monto, String otros) {
        FF.CrearPagoTarjeta(id, nombrePasajero, nombreConductor, monto, otros);
    }
    
    public void crearAgrupaciones() {
        
    }
    
}
