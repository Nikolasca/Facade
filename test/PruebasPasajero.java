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
        assertEquals("NombrePasajero,1,Pasajero,", x.llamarMetodoGeneral("Consultar_Usuario, NombrePasajero, 1, Pasajero"));
    }
}
