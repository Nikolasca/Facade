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
    public void CrearReserva() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("CrearReserva,Pasajero,111,Viaje1-0001-01/01/2000-Primera Reserva-Calle127 #34 27");
        assertEquals("Nombre: Viaje1, id: 0001, fecha: 01/01/2000, concepto: Primera Reserva, lugar: Calle127 #34 27", x.llamarMetodoGeneral(""));
    }
}
