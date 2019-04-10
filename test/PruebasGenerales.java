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
public class PruebasGenerales {
    
    public PruebasGenerales() {
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
    // Aftertest beforetest
    @Test
    public void hello() {
    Proxy x = new Proxy();
    String nombre = "1";
    String pass = "1";
    String tipo = "Pasajero";

    x.crearUsuario(nombre, pass, tipo);
    //Proxy probado1 = x.llamarMetodoGeneral();

     //   assertTrue(probado1.ingresar("1", "1"));
    }
}
