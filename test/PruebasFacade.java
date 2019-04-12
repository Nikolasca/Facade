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
    public void crearPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        assertEquals("Pasajero1,111,Pasajero,", F.Acceso("Consultar_Usuario", "Pasajero1", "111", "Pasajero1"));
    }

    @Test
    public void crearConductor() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Conductor1", "111", "Conductor");
        assertEquals("Conductor1,111,Conductor,", F.Acceso("Consultar_Usuario", "Conductor1", "111", "Conductor1"));
    }

    @Test
    public void crearAdmin() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Admin1", "111", "Administrador");
        assertEquals("Admin1,111,Administrador,", F.Acceso("Consultar_Usuario", "Admin1", "111", "Admin1"));
    }

    @Test
    public void modPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("mod_Usuario", "Pasajero1", "111", "Pasajero1-Pasajero1-123");
        assertEquals("Pasajero1,123,Pasajero,", F.Acceso("Consultar_Usuario", "Pasajero1", "123", "Pasajero1"));
    }

    @Test
    public void modConductor() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Conductor1", "111", "Conductor");
        F.Acceso("mod_Usuario", "Conductor1", "111", "Conductor1-ElConductor-123");
        assertEquals("ElConductor,123,Conductor,", F.Acceso("Consultar_Usuario", "ElConductor", "123", "ElConductor"));
    }

    @Test
    public void crearYConsultarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        assertEquals("Nombre: Visita a Unicentro, id: 1, fecha: 01/01/2019, concepto: Visita a Unicentro, lugar: Unicentro", F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void modificarLugarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        F.Acceso("ModificarLugarReserva", "Pasajero1", "111", "1-Unicentro Salida Sur");
        assertEquals("Nombre: Visita a Unicentro, id: 1, fecha: 01/01/2019, concepto: Visita a Unicentro, lugar: Unicentro Salida Sur", F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void eliminarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        F.Acceso("EliminarReserva", "Pasajero1", "111", "1");
        assertEquals("", F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void crearPagoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("CrearPago", "Pasajero1", "111", "Visita a Unicentro-1-5000-01/01/2019-Visita a Unicentro");
        assertEquals("Nombre: Visita a Unicentro, id: 1, monto: 5000, fecha: 01/01/2019, concepto: Visita a Unicentro", F.Acceso("LeerPago", "Pasajero1", "111", "1"));
    }

    @Test
    public void crearCreditoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("crearCredito", "Pasajero1", "111", "1-Pasajero1-Conductor1-10-CVV:1,Num:92929282882,FechaVenc:Manana");
        assertEquals("Datos crédito{id=1, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=CVV:1,Num:92929282882,FechaVenc:Manana}\n", F.Acceso("leerEoC", "Pasajero1", "111", "Pasajero1-1"));
    }

    @Test
    public void crearEfectivoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("crearEfectivo", "Pasajero1", "111", "2-Pasajero1-Conductor1-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        assertEquals("Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n", F.Acceso("leerEoC", "Pasajero1", "111", "Pasajero1-2"));
    }

    /*
    @Test
    public void verTransporte() {

    }
     */
    @Test
    public void verPermisosPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        assertEquals("CrearReserva,LeerReserva,ModificarLugarReserva,EliminarReserva,CrearPago,LeerPago,Consultar_Usuario,mod_Usuario,crearCredito,crearEfectivo,VerPagos,VerTransporte,crearTarjetaCredito,crearTarjetaDebito,ModificarTarjetaCredito,ModificarTarjetaDebito,VerViajesRealizados,VerRutas,VerAyudas,GuardarUbicaciones,CerrarSesion",
                F.Acceso("verPermisos", "Pasajero1", "111", ""));
    }

    @Test
    public void leerPagosPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero");
        F.Acceso("crearEfectivo", "Pasajero1", "111", "2-Pasajero1-Conductor1-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        F.Acceso("crearCredito", "Pasajero1", "111", "1-Pasajero1-Conductor2-700-CVV:1,Num:92929282882,FechaVenc:Manana");
        assertEquals("Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n"
                + "Datos crédito{id=1, nombrePasajero=Pasajero1, nombreConductor=Conductor2, monto=700.0, otros=CVV:1,Num:92929282882,FechaVenc:Manana}\n", F.Acceso("verPagosP", "Pasajero1", "111", "Pasajero1"));
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
        assertEquals(F.Acceso("verPagosC", "Conductor1", "1112", "Conductor1"), "Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n"
                + "Datos efectivo {id=1, nombrePasajero=Pasajero2, nombreConductor=Conductor1, monto=700.0, otros=Moneda:Dolar,MontoDado=2000,MontoDevuelto=1300}\n"
                + "Datos crédito{id=3, nombrePasajero=Pasajero3, nombreConductor=Conductor1, monto=700.0, otros=CVV:1,Num:92929282882,FechaVenc:Manana}\n");

    }

    @Test
    public void verPermisosConductor() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Conductor1", "111", "Conductor");
        assertEquals("LeerPago,CrearRuta,ModificarRuta,EliminarRuta,VerRuta,VerHorario,CerrarSesión", F.Acceso("verPermisos", "Conductor1", "111", ""));
    }

    @Test
    public void verPermisosAdmin() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Admin1", "111", "Administrador");
        assertEquals("CrearVehiculo,crearAgrupacion,AgregarAgrupacion,EliminarElemento,eliminar_Usuario,Consultar_Usuario,CerrarSesion,InmovilizarUsuario,VerTodos", F.Acceso("verPermisos", "Admin1", "111", ""));
    }

    @Test

    public void crearVehículoAdmin() throws NoSuchMethodException {
   Facade f = new Facade();
    f.Acceso("CrearVehiculo", "hola","123","NombrePrueba-Tipo-ABC123-4-Mazda");
    assertEquals("GrupoBase NombrePrueba Mazda 4 ABC123",f.Acceso("VerTransporte", "hola","123","NombreVehiculo"));
    
    }

    @Test
    public void crearAgrupacionAdmin() throws NoSuchMethodException {
        Facade f = new Facade();
        f.Acceso("crearAgrupacion", "Hola", "123", "GrupoNuevo");
        assertEquals("GrupoBase   0 GrupoNuevo ", f.Acceso("VerTodos", "hola", "123", ""));
    }

    @Test
    public void AgregarAgrupacionAdmin() throws NoSuchMethodException {
    }

    @Test
    public void EliminarElementoAdmin() throws NoSuchMethodException {
        Facade f = new Facade();
        f.Acceso("crearAgrupacion", "Hola", "123", "Particular-1");
        f.Acceso("crearAgrupacion", "Hola", "123", "Publico-2");
        f.Acceso("crearAgrupacion", "Hola", "123", "Otro-3");
        f.Acceso("EliminarElemento", "Hola", "123", "2");
        assertEquals("GrupoBase   0 Particular GrupoBase   0 Otro ", f.Acceso("VerTodos", "hola", "123", ""));
    }

    @Test
    public void Eliminar_UsuarioAdmin() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Admin1", "111", "Administrador");
        F.Crear_Usuario("Conductor1", "111", "Conductor");
        F.Acceso("eliminar_Usuario", "Admin1", "111", "Conductor1-111");
        assertEquals("", F.Acceso("Consultar_Usuario", "Admin1", "111", "Conductor1"));
    }
}
