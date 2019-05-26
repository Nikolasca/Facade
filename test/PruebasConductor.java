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
        x.crearUsuario("NombreConductor", "2", "Conductor","wq",1,"er","e");
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
    public void ConsultarInformacion() throws NoSuchMethodException {
        Proxy x = new Proxy();
        assertEquals("NombreConductor,2,Conductor,", x.llamarMetodoGeneral("Consultar_Usuario,NombreConductor,2,NombreConductor"));
    }

    @Test
    public void EliminarUsuario() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("eliminar_Usuario,NombreConductor,2,NombreConductor-2");
        assertEquals("", x.llamarMetodoGeneral("Consultar_Usuario,NombreConductor,2,NombreConductor"));
    }

    @Test
    public void ModificarUsuario() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("mod_Usuario,NombreConductor,2,NombreConductor-NombreConductor1-2");
        assertEquals("NombreConductor1,2,Conductor,", x.llamarMetodoGeneral("Consultar_Usuario,NombreConductor1,2,NombreConductor1"));
    }

    @Test
    public void VerPagosConductor() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.crearUsuario("NombrePasajero1", "1", "Pasajero",2);
        x.crearUsuario("NombrePasajero2", "2", "Pasajero",3);
        x.llamarMetodoGeneral("crearEfectivo,NombrePasajero1,1,2-NombrePasajero1-NombreConductor-10.0-Moneda:Peso;MontoDado=20;MontoDevuelto=10");
        x.llamarMetodoGeneral("crearCredito,NombrePasajero2,2,3-NombrePasajero2-NombreConductor-700.0-CVV:1;Num:92929282882;FechaVenc:Manana");
        assertEquals("Datos efectivo {id=2, nombrePasajero=NombrePasajero1, nombreConductor=NombreConductor, monto=10.0, otros=Moneda:Peso;MontoDado=20;MontoDevuelto=10}\n"
                + "Datos crédito{id=3, nombrePasajero=NombrePasajero2, nombreConductor=NombreConductor, monto=700.0, otros=CVV:1;Num:92929282882;FechaVenc:Manana}\n",
                x.llamarMetodoGeneral("verPagosC,NombreConductor,2,NombreConductor"));
    }
}
