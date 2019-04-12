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
public class PruebasConductor {

    public PruebasConductor() {
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
        x.crearUsuario("NombreConductor", "2", "Conductor");
        assertTrue(x.validarUsuario("NombreConductor", "2"));
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
        assertEquals("LeerPago,CrearRuta,ModificarRuta,EliminarRuta,VerRuta,VerHorario,CerrarSesión", x.llamarMetodoGeneral("verPermisos,NombreConductor,2,Conductor"));
    }
    
    @Test
    public void VerPagosConductor() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("crearEfectivo,Pasajero1,111,2-Pasajero1-NombreConductor-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        x.llamarMetodoGeneral("crearCredito,Pasajero3,222,3-Pasajero3-NombreConductor-700-CVV:1,Num:92929282882,FechaVenc:Manana");
        assertEquals(x.llamarMetodoGeneral("verPagosC,NombreConductor,2,NombreConductor"), "Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=NombreConductor, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n"
                + "Datos crédito{id=3, nombrePasajero=Pasajero3, nombreConductor=NombreConductor, monto=700.0, otros=CVV:1,Num:92929282882,FechaVenc:Manana}\n");

    }
}
