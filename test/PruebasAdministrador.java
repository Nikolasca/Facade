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
public class PruebasAdministrador {
    
    public PruebasAdministrador() {
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
        x.crearUsuario("NombreAdministrador", "3", "Administrador");
        assertTrue(x.validarUsuario("NombreAdministrador", "3"));
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
        assertEquals("CrearVehiculo,crearAgrupacion,AgregarAgrupacion,EliminarElemento,eliminar_Usuario,Consultar_Usuario,CerrarSesion,InmovilizarUsuario",
                x.llamarMetodoGeneral("verPermisos,NombreAdministrador,3,Administrador"));
    }

    @Test
    public void ConsultarInformacion() throws NoSuchMethodException {
        Proxy x = new Proxy();
        assertEquals("NombreAdministrador,3,Administrador,", x.llamarMetodoGeneral("Consultar_Usuario,NombreAdministrador,3,NombreAdministrador"));
    }

    @Test
    public void EliminarUsuario() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("eliminar_Usuario,NombreAdministrador,3,Administrador-3");
        assertEquals("", x.llamarMetodoGeneral("Consultar_Usuario,NombreAdministrador,3,Administrador"));
    }

    @Test
    public void ModificarUsuario() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("mod_Usuario,NombreAdministrador,3,NombreAdministrador-NombreAdministrador1-3");
        assertEquals("NombreAdministrador1,3,Administrador,", x.llamarMetodoGeneral("Consultar_Usuario,NombreAdministrador1,3,NombreAdministrador1"));
    }
}
