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
    public void devolverPermisosPasajero(){
        Facade F=new Facade();
    }
    
}
