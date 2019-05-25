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
        x.crearUsuario("NombreAdministrador", "3", "Administrador",200);
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
        assertEquals("CrearVehiculo,crearAgrupacion,AgregarAgrupacion,EliminarElemento,eliminar_Usuario,Consultar_Usuario,CerrarSesion,InmovilizarUsuario,VerTodos,ModificarNombre_Elemento",
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

    @Test
    public void CrearIndividual() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("CrearVehiculo,Individual,123,NombrePrueba-Tipo-ABC123-4-Mazda");
        System.out.println(x.llamarMetodoGeneral("VerTransporte,Individual,123,NombreVehiculo"));
        assertEquals("GrupoBase NombrePrueba Mazda 4 ABC123", x.llamarMetodoGeneral("VerTransporte,Individual,123,NombreVehiculo")); // --- Se repiten lo que se imprime
    }

    @Test
    public void CrearGrupo() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("crearAgrupacion,Hola,123,GrupoNuevo");
        System.out.println(x.llamarMetodoGeneral("VerTodos,hola,123, "));
        assertEquals("GrupoBase   0 GrupoNuevo ", x.llamarMetodoGeneral("VerTodos,Hola,123, ")); // --- Se repiten lo que se imprime
    }

    @Test
    public void Modificar() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("crearAgrupacion,A,1234,Particular-11");
        x.llamarMetodoGeneral(" ModificarNombre_Elemento,A,1234,11-Nombrenuevo");
        System.out.println(x.llamarMetodoGeneral("VerTodos,A,1234, "));
        assertEquals("GrupoBase   0 Nombrenuevo ", x.llamarMetodoGeneral("VerTodos,A,1234, ")); // --- Se repiten lo que se imprime
    }

    @Test
    public void EliminarIndividual() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("CrearVehiculo,Individual,123,NombrePrueba-1");
        x.llamarMetodoGeneral("EliminarElemento,Individual,123,1");
        assertEquals("", x.llamarMetodoGeneral("VerTransporte,Individual,123,NombreVehiculo"));
    }

    @Test
    public void EliminarGrupo() throws NoSuchMethodException {
        Proxy x = new Proxy();
        x.llamarMetodoGeneral("crearAgrupacion,Hola,123,Particular-1");
        x.llamarMetodoGeneral("crearAgrupacion,Hola,123,Publico-2");
        x.llamarMetodoGeneral("EliminarElemento,Hola,123,2");
        System.out.println(x.llamarMetodoGeneral("VerTodos,Hola,123, "));
        assertEquals("GrupoBase   0 Particular GrupoBase   0 Otro ", x.llamarMetodoGeneral("VerTodos,Hola,123, ")); // --- Se repiten lo que se imprime
    }
    
    /*
    @Test
    public void AñadirCaracteristica() throws NoSuchMethodException { // --- No hay métodos para probar
    }

    @Test
    public void ModificarCaracteristica() throws NoSuchMethodException { // --- No hay métodos para probar
        Proxy x = new Proxy();
    }

    @Test
    public void EliminarCaracteristica() throws NoSuchMethodException { // --- No hay métodos para probar
        Proxy x = new Proxy();
    }
     */
}
