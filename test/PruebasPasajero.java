/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Proxy.Proxy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Valentina
 */
public class PruebasPasajero {

    public PruebasPasajero() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Proxy x = new Proxy();
        x.crearUsuario("NombrePasajero", "1", "Pasajero");
        assertTrue(x.validarUsuario("NombrePasajero", "1"));
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void VerPermisos() throws NoSuchMethodException {
        Proxy x = new Proxy();
        assertEquals("CrearReserva,LeerReserva,ModificarLugarReserva,EliminarReserva,CrearPago,LeerPago,Consultar_Usuario,mod_Usuario,crearCredito,crearEfectivo,VerPagos,VerTransporte,crearTarjetaCredito,crearTarjetaDebito,ModificarTarjetaCredito,ModificarTarjetaDebito,VerViajesRealizados,VerRutas,VerAyudas,GuardarUbicaciones,CerrarSesion",
                x.llamarMetodoGeneral("verPermisos,NombrePasajero,1,Pasajero"));
    }

    @Test
    public void ConsultarInformacion() throws NoSuchMethodException {
        Proxy x = new Proxy();
        assertEquals("NombrePasajero,1,Pasajero,", x.llamarMetodoGeneral("Consultar_Usuario,NombrePasajero,1,NombrePasajero"));
    }

    @Test
    public void EliminarUsuario() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("eliminar_Usuario,NombrePasajero,1,NombrePasajero-1");
        assertEquals("", x.llamarMetodoGeneral("Consultar_Usuario,NombrePasajero,1,NombrePasajero"));
    }

    @Test
    public void ModificarUsuario() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("mod_Usuario,NombrePasajero,1,NombrePasajero-NombrePasajero1-1");
        assertEquals("NombrePasajero1,1,Pasajero,", x.llamarMetodoGeneral("Consultar_Usuario,NombrePasajero1,1,NombrePasajero1"));
    }

    @Test
    public void Crear_VerReserva() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("CrearReserva,NombrePasajero,1,Viaje1-0001-01/01/2000-Primera Reserva-Calle 127 #34 27");
        assertEquals("Nombre: Viaje1, id: 0001, fecha: 01/01/2000, concepto: Primera Reserva, lugar: Calle 127 #34 27", x.llamarMetodoGeneral("LeerReserva,NombrePasajero,1,0001"));
    }

    @Test
    public void ModificarReserva() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("CrearReserva,NombrePasajero,1,Viaje1-0001-01/01/2000-Primera Reserva-Calle 127 #34 27");
        x.llamarMetodoGeneral("ModificarLugarReserva,NombrePasajero,1,0001-Calle 127 #27 27");
        assertEquals("Nombre: Viaje1, id: 0001, fecha: 01/01/2000, concepto: Primera Reserva, lugar: Calle 127 #27 27", x.llamarMetodoGeneral("LeerReserva,NombrePasajero,1,0001"));
    }

    @Test
    public void EliminarReserva() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("CrearReserva,NombrePasajero,1,Viaje1-0002-01/01/2000-Primera Reserva-Calle 127 #34 27");
        x.llamarMetodoGeneral("EliminarReserva,NombrePasajero,1,0002");
        assertEquals("", x.llamarMetodoGeneral("LeerReserva,NombrePasajero,1,0002"));
    }

    @Test
    public void crearPagoPasajero() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("CrearPago,NombrePasajero,1,Viaje1-0001-5000-01/01/2000-Primera Reserva");
        assertEquals("Nombre: Viaje1, id: 0001, monto: 5000, fecha: 01/01/2000, concepto: Primera Reserva", x.llamarMetodoGeneral("LeerPago,NombrePasajero,1,0001"));
    }

    @Test
    public void VerPagosPasajero() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("crearEfectivo,NombrePasajero,1,2-NombrePasajero-NombreConductor1-10.0-Moneda:Peso;MontoDado=20;MontoDevuelto=10");
        x.llamarMetodoGeneral("crearCredito,NombrePasajero,1,1-NombrePasajero-NombreConductor2-700.0-CVV:1;Num:92929282882;FechaVenc:Manana");
        assertEquals("Datos efectivo {id=2, nombrePasajero=NombrePasajero, nombreConductor=NombreConductor1, monto=10.0, otros=Moneda:Peso;MontoDado=20;MontoDevuelto=10}\n"
                + "Datos crédito{id=1, nombrePasajero=NombrePasajero, nombreConductor=NombreConductor2, monto=700.0, otros=CVV:1;Num:92929282882;FechaVenc:Manana}\n",
                x.llamarMetodoGeneral("verPagosP,NombrePasajero,1,NombrePasajero"));
    }
}
