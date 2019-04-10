/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import taller.facade.Facade;

/**
 *
 * @author Pedro de Jesús
 */
public class PruebasFacade {

    public PruebasFacade() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void crearPasajero() {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        assertEquals("Pasajero1,111,Pasajero,", F.Consultar_Usuario("Pasajero1"));
    }

    @Test
    public void crearConductor() {
        Facade F = new Facade();
        F.Crear_Usuario("Conductor1", "111", "Conductor");
        assertEquals("Conductor1,111,Conductor,", F.Consultar_Usuario("Conductor1"));
    }

    @Test
    public void crearAdmin() {
        Facade F = new Facade();
        F.Crear_Usuario("Admin1", "111", "Administrador");
        assertEquals("Admin1,111,Administrador,", F.Consultar_Usuario("Admin1"));
    }

    @Test
    public void modPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("mod_Usuario", "Pasajero1", "111", "Pasajero1-Pasajero1-123");
        assertEquals("Pasajero1,123,Pasajero,", F.Consultar_Usuario("Pasajero1"));
    }

    @Test
    public void crearYConsultarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        assertEquals("Nombre: Visita a Unicentro, id: 1, fecha: 01/01/2019, concepto: Visita a Unicentro, lugar: Unicentro", F.LeerReserva("1"));
        //assertEquals("Visita a Unicentro, id: 1",F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void modificarLugarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        F.Acceso("ModificarLugarReserva", "Pasajero1", "111", "1-Unicentro Salida Sur");
        assertEquals("Nombre: Visita a Unicentro, id: 1, fecha: 01/01/2019, concepto: Visita a Unicentro, lugar: Unicentro Salida Sur", F.LeerReserva("1"));
        //assertEquals("Visita a Unicentro, id: 1",F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void eliminarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        F.Acceso("EliminarReserva", "Pasajero1", "111", "1");
        assertEquals("", F.LeerReserva("1"));
        //assertEquals("Visita a Unicentro, id: 1",F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void crearPagoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("CrearPago", "Pasajero1", "111", "Visita a Unicentro-1-5000-01/01/2019-Visita a Unicentro");
        assertEquals("Nombre: Visita a Unicentro, id: 1, monto: 5000, fecha: 01/01/2019, concepto: Visita a Unicentro", F.LeerPago("1"));
    }

    @Test
    public void crearCreditoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("crearCredito", "Pasajero1", "111", "1-Pasajero1-Conductor1-10-CVV:1,Num:92929282882,FechaVenc:Manana");
        assertEquals("Datos crédito{id=1, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=CVV:1,Num:92929282882,FechaVenc:Manana}\n", F.leerEoC("Pasajero1", 1));
    }

    @Test
    public void crearEfectivoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("crearEfectivo", "Pasajero1", "111", "2-Pasajero1-Conductor1-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        assertEquals("Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n", F.leerEoC("Pasajero1", 2));
    }

    @Test
    public void verTransporte() {
    }

    @Test
    public void verPermisosPasajero() {
    }

    @Test
    public void leerPagosPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("crearEfectivo", "Pasajero1", "111", "2-Pasajero1-Conductor1-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        F.Acceso("crearCredito", "Pasajero1", "111", "1-Pasajero1-Conductor2-700-CVV:1,Num:92929282882,FechaVenc:Manana");
        assertEquals("Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n"
                + "Datos crédito{id=1, nombrePasajero=Pasajero1, nombreConductor=Conductor2, monto=700.0, otros=CVV:1,Num:92929282882,FechaVenc:Manana}\n", F.verPagosP("Pasajero1"));
    }

    @Test
    public void leerPagosConductor() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Crear_Usuario("Pasajero2", "111", "Pasajero");
        F.Crear_Usuario("Pasajero3", "222", "Pasajero");
        F.Crear_Usuario("Conductor1", "1112", "Conductor");
        F.Acceso("crearEfectivo", "Pasajero1", "111", "2-Pasajero1-Conductor1-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        F.Acceso("crearEfectivo", "Pasajero2", "111", "1-Pasajero2-Conductor1-700-Moneda:Dolar,MontoDado=2000,MontoDevuelto=1300");
        F.Acceso("crearCredito", "Pasajero3", "222", "3-Pasajero3-Conductor1-700-CVV:1,Num:92929282882,FechaVenc:Manana");
        assertEquals(F.verPagosC("Conductor1"), "Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n"
                + "Datos efectivo {id=1, nombrePasajero=Pasajero2, nombreConductor=Conductor1, monto=700.0, otros=Moneda:Dolar,MontoDado=2000,MontoDevuelto=1300}\n"
                + "Datos crédito{id=3, nombrePasajero=Pasajero3, nombreConductor=Conductor1, monto=700.0, otros=CVV:1,Num:92929282882,FechaVenc:Manana}\n");

    }
}
