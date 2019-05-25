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
import Composite.*;
import Decorator.*;
import Flyweight.FlyWeight;
import Flyweight.FlyWeightFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nikolas
 */
public class Facade {

    private PagoGrupo G1 = new PagoGrupo();
    private ReservaGrupo G2 = new ReservaGrupo();
    private ArrayList<Usuario> componentes = new ArrayList();
    private static Facade facade;
    private FlyWeightFactory FF = new FlyWeightFactory();
    private MedioTransporte mT = new MedioTransporte("GrupoBase");

    public Facade() {
        Usuario user = new Adapter("Hola", "123", "Pedro", "A1", "pedrovamounisabana", "216");
        this.componentes.add(user);
    }

    public static Facade getFacade() {
        if (facade == null) {
            facade = new Facade();
        }
        return facade;
    }

    public String Acceso(String Accion, String NombreUser, String PassUser, String Para) throws NoSuchMethodException {
        String x = "";
        int a = 0, w = 0;
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getUsuario().equals(NombreUser));
            a = i;
        }
        Method[] metodos = componentes.get(a).getClass().getMethods();
        Method[] metodosFacade = Facade.class.getMethods();
        Method methodcall = componentes.get(a).getClass().getDeclaredMethod("Permisos");
        String cadena = "";
        try {
            cadena += (String) methodcall.invoke(componentes.get(a)) + "; ";
            String[] parts = cadena.split(",");
            String[] para = Para.split("-");
            for (int j = 0; j < parts.length; j++) {
                if (Accion.equals("CrearReserva")) {
                    CrearReserva(para[0], para[1], para[2], para[3], para[4]);
                    j = parts.length;
                }
                if (Accion.equals("LeerReserva")) {
                    x = LeerReserva(para[0]);
                    j = parts.length;
                }
                if (Accion.equals("ModificarLugarReserva")) {
                    ModificarLugarReserva(para[0], para[1]);
                    j = parts.length;
                }
                if (Accion.equals("CrearPago")) {
                    CrearPago(para[0], para[1], Integer.parseInt(para[2]), para[3], para[4]);
                    j = parts.length;
                }
                if (Accion.equals("EliminarPago")) {
                    EliminarPago(G1.ObtenerPago(para[0]));
                    j = parts.length;
                }
                if (Accion.equals("EliminarReserva")) {
                    EliminarReserva(G2.ObtenerReserva(para[0]));
                    j = parts.length;
                }
                if (Accion.equals("Modificar_ConceptoPago")) {
                    Modificar_ConceptoPago(para[0], para[1]);
                    j = parts.length;
                }
                if (Accion.equals("LeerPago")) {
                    x = LeerPago(para[0]);
                    j = parts.length;
                }
                if (Accion.equals("Consultar_Usuario")) {
                    x = Consultar_Usuario(para[0]);
                    j = parts.length;
                }
                if (Accion.equals("eliminar_Usuario")) {
                    eliminar__Usuario(para[0], para[1]);
                    System.out.println("eU");
                    j = parts.length;
                }
                if (Accion.equals("mod_Usuario")) {
                    mod_Usuario(para[0], para[1], para[2]);
                    j = parts.length;
                }
                if (Accion.equals("crearCredito")) {
                    crearCredito(Integer.parseInt(para[0]), para[1], para[2], Float.parseFloat(para[3]), para[4]);
                    j = parts.length;
                }
                if (Accion.equals("crearEfectivo")) {
                    crearEfectivo(Integer.parseInt(para[0]), para[1], para[2], Float.parseFloat(para[3]), para[4]);
                    j = parts.length;
                }
                if (Accion.equals("EliminarPago")) {
                    componentes.get(a).getFactory().EliminarPago(componentes.get(a).getFactory().Getpago(Integer.parseInt(para[0])));
                    j = parts.length;
                }
                if (Accion.equals("ModificarPago")) {
                    componentes.get(a).getFactory().ModificarPago(Integer.parseInt(para[0]), para[1], para[2], para[3]);
                    j = parts.length;
                }
                if (Accion.equals("VerPagos")) {
                    componentes.get(a).getFactory().toString();
                    j = parts.length;
                }
                if (Accion.equals("crearAgrupacion")) {
                    crearAgrupacion(para[0]);
                    j = parts.length;
                }
                if (Accion.equals("CrearVehiculo")) {
                    if (para.length == 8) {
                        crearVehiculo(para[0], para[1], para[2], para[3], para[4], para[5], para[6], para[7]);
                        j = parts.length;
                    } else {
                        crearVehiculoconCarac(para[0], para[1], para[2], para[3], para[4], para[5], para[6], para[7], Integer.parseInt(para[8]), para[9], para[10]);
                        j = parts.length;
                    }
                }
                if (Accion.equals("ModificarIndividual")) {
                    ModificarIndividual(para[0], para[1]);
                    j = parts.length;
                }
                if (Accion.equals("EliminarElemento")) {
                    eliminarElemento(para[0]);
                    j = parts.length;
                }
                if (Accion.equals("VerTransporte")) {
                    x = verTransporte(para[0]);
                    j = parts.length;
                }
                if (Accion.equals("verPagosC")) {
                    x = verPagosC(para[0]);
                    j = parts.length;
                }
                if (Accion.equals("verPagosP")) {
                    x = verPagosP(para[0]);
                    j = parts.length;
                }
                if (Accion.equals("verPermisos")) {
                    x = componentes.get(a).Permisos();
                    j = parts.length;
                }
                if (Accion.equals("leerEoC")) {
                    x = leerEoC(para[0], Integer.parseInt(para[1]));
                    j = parts.length;
                }
                if (Accion.equals("leerEoC")) {
                    x = leerEoC(para[0], Integer.parseInt(para[1]));
                    j = parts.length;
                }
            }
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Facade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return x;
    }

    public void Crear_Usuario(String User, String pass, String Tipo, String nombreCompleto, String id, String email, String telefono) {
        if (Tipo.equals("Pasajero")) {
            Usuario usuario = new Pasajero(User, pass, nombreCompleto, id, email, telefono);
            usuario.setTipo_Usuario(Tipo);
            componentes.add(usuario);
        } else if (Tipo.equals("Conductor")) {
            Usuario usuario = new Conductor(User, pass, nombreCompleto, id, email, telefono);
            usuario.setTipo_Usuario(Tipo);
            componentes.add(usuario);
        } else if (Tipo.equals("Administrador")) {
            Usuario usuario = new Adapter(User, pass, nombreCompleto, id, email, telefono);
            usuario.setTipo_Usuario(Tipo);
            componentes.add(usuario);
        } else {
            System.out.print("No hizo match tipo");
        }
    }

    public String Consultar_Usuario(String User) {
        String info = "";
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getUsuario().equalsIgnoreCase(User)) {
                info = componentes.get(i).getUsuario() + "," + componentes.get(i).getPassword() + "," + componentes.get(i).getTipo_Usuario() + "," + componentes.get(i).getNombreapellido() + ","
                        + componentes.get(i).getId() + "," + componentes.get(i).getEmail() + "," + componentes.get(i).getTelefono() + ",";
            }
        }
        return info;
    }

    public void eliminar__Usuario(String User, String pass) {
        int a = 0;
        System.out.println("Eli");
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getUsuario().equalsIgnoreCase(User) && componentes.get(i).getPassword().equalsIgnoreCase(pass)) {
                a = i;
            }
        }
        componentes.remove(a);
    }

    public void mod_Usuario(String user, String carac, String nuevo) {
        int a = 0;
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getUsuario().equalsIgnoreCase(user)) {
                a = i;
            }
        }
        if (carac.equalsIgnoreCase("usuario")) {
            componentes.get(a).setUsuario(nuevo);
        } else if (carac.equalsIgnoreCase("contrasena")) {
            componentes.get(a).setPassword(nuevo);
        } else if (carac.equalsIgnoreCase("email")) {
            componentes.get(a).setEmail(nuevo);
        } else if (carac.equalsIgnoreCase("telefono")) {
            componentes.get(a).setTelefono(nuevo);
        } else if (carac.equalsIgnoreCase("nombreCompleto")) {
            componentes.get(a).setNombreapellido(nuevo);
        }
    }

    public void crearCredito(int id, String nombrePasajero, String nombreConductor, float monto, String otros) {
        FF.CrearPagoTarjeta(id, nombrePasajero, nombreConductor, monto, otros);
        FlyWeight F = FF.Getpago(id);
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getUsuario().equalsIgnoreCase(nombrePasajero)) {
                componentes.get(i).AñadirPago(F);
            }
        }
    }

    public void crearEfectivo(int id, String nombrePasajero, String nombreConductor, float monto, String otros) {
        FF.CrearPagoEfectivo(id, nombrePasajero, nombreConductor, monto, otros);
        FlyWeight F = FF.Getpago(id);
        int a = 0;
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getUsuario().equalsIgnoreCase(nombrePasajero)) {
                a = i;
            }
        }
        componentes.get(a).AñadirPago(F);
    }

    public String leerEoC(String nombreU, int id) {
        String info = "";
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getUsuario().equalsIgnoreCase(nombreU)) {
                info = componentes.get(i).getPago(id);
            }
        }
        return info;
    }

    public void crearAgrupacion(String NombreGrupo) {
        MedioTransporte grupo = new MedioTransporte(NombreGrupo);
        mT.Crear(grupo);
    }

    public void crearVehiculo(String nombreG, String nombre, String tipo, String placa, String cantidadpuestos, String marca, String ano, String referencia) {
        Transporte aN = new Individual(nombre, tipo, placa, cantidadpuestos, marca, ano, referencia);
        if (nombreG.equalsIgnoreCase("")) {
            mT.Crear(aN);
        } else {
            mT.getGrupo(nombreG).Crear(aN);
        }
    }

    public void crearVehiculoconCarac(String nombreG, String nombre, String tipo, String placa, String cantidadpuestos, String marca, String ano, String referencia, int capacidad, String descripcion, String identificador) {
        Transporte aN = new IdentificadorDecorator(identificador, new DescripcionDecorator(descripcion, new CapacidadDecorator(capacidad, new Individual(nombre, tipo, placa, cantidadpuestos, marca, ano, referencia))));
        if (nombreG.equalsIgnoreCase("")) {
            mT.Crear(aN);
        } else {
            mT.getGrupo(nombreG).Crear(aN);
        }
    }

    public String verTransporte(String nombreG) {
        String info = "";
        info = mT.ConsultarNombre(nombreG);
        return info;
    }

    public void ModificarIndividual(String caracteristica, String nuevo) {
        mT.cambiarAtributo(caracteristica, nuevo);
        System.out.println("ModInd" + caracteristica);
    }

    public void eliminarElemento(String nombre) {
        mT.Eliminar(mT.getGrupo(nombre));
    }

    public void CrearReserva(String nombre, String id, String fecha, String concepto, String lugar) {
        Reserva reserva = new Reserva(nombre, id, fecha, concepto, lugar);
        G2.AñadirGrupito(reserva);
    }

    public void EliminarReserva(Reserva r) {
        G2.EliminarAlGrupito(r);
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

    public void CrearPago(String nombre, String id, int pago, String fecha, String concepto) {
        Pago pago1 = new Pago(nombre, id, pago, fecha, concepto);
        G1.AñadirGrupito(pago1);
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

    public String verPagosP(String nombreU) {
        String info = "";
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).getUsuario().equalsIgnoreCase(nombreU)) {
                info = componentes.get(i).getPagos(nombreU);
            }
        }
        return info;
    }

    public String verPagosC(String nombreC) {
        String info = "";
        info = FF.toStringPagosConductor(nombreC);
        return info;
    }
}
