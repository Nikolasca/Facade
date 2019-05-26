/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import AdapterPackage.Conductor;
import AdapterPackage.Pasajero;
import AdapterPackage.Usuario;
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
        F.Acceso("Crear_Usuario", "a", "b", "Pasajero1-111-Pasajero-Hernando-1-S8-Hernyhotmail-22");
        assertEquals("Pasajero1,111,Pasajero,Hernando,1,S8,Hernyhotmail,", F.Acceso("Consultar_UsuarioId", "Pasajero1", "111", "22"));
    }

    @Test
    public void crearConductor() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Conductor1", "111", "Conductor", "Juan Alvarez", 1, "aa", "juanCoAlvarez.hotmail", 134);
        assertEquals("Conductor1,111,Conductor,Juan Alvarez,1,aa,juanCoAlvarez.hotmail,", F.Acceso("Consultar_Usuario", "Conductor1", "111", "Conductor1"));
    }

    @Test
    public void crearAdmin() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Admin1", "111", "Administrador", 12);
        assertEquals("Admin1,111,Administrador,", F.Acceso("Consultar_Usuario", "Admin1", "111", "Admin1"));
    }

    @Test
    public void modPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "Prenom", 1, "qq", "ema", 122);
        F.Acceso("mod_Usuario", "Pasajero1", "111", "Pasajero1-nombre-Sunom");
        F.Acceso("mod_Usuario", "Pasajero1", "111", "Pasajero1-email-Emoaa");
        F.Acceso("mod_Usuario", "Pasajero1", "111", "Pasajero1-telefono-112");
        F.Acceso("mod_Usuario", "Pasajero1", "111", "Pasajero1-contrasena-999");
        assertEquals("Pasajero1,999,Pasajero,Sunom,112,qq,Emoaa,", F.Acceso("Consultar_Usuario", "Pasajero1", "111", "Pasajero1"));
    }

    @Test
    public void modConductor() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Conductor1", "111", "Conductor", "c", 3, "f", "rr", 5);
        F.Acceso("mod_Usuario", "Conductor1", "111", "Conductor1-usuario-PepoConductor");
        assertEquals("PepoConductor,111,Conductor,c,3,f,rr,", F.Acceso("Consultar_Usuario", "PepoConductor", "111", "PepoConductor"));
    }

    @Test
    public void crearYConsultarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        assertEquals("Nombre: Visita a Unicentro, id: 1, fecha: 01/01/2019, concepto: Visita a Unicentro, lugar: Unicentro", F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void modificarLugarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        F.Acceso("ModificarLugarReserva", "Pasajero1", "111", "1-Unicentro Salida Sur");
        assertEquals("Nombre: Visita a Unicentro, id: 1, fecha: 01/01/2019, concepto: Visita a Unicentro, lugar: Unicentro Salida Sur", F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void eliminarReservaPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("CrearReserva", "Pasajero1", "111", "Visita a Unicentro-1-01/01/2019-Visita a Unicentro-Unicentro");
        F.Acceso("EliminarReserva", "Pasajero1", "111", "1");
        assertEquals("", F.Acceso("LeerReserva", "Pasajero1", "111", "1"));
    }

    @Test
    public void crearPagoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("CrearPago", "Pasajero1", "111", "Visita a Unicentro-1-5000-01/01/2019-Visita a Unicentro");
        assertEquals("Nombre: Visita a Unicentro, id: 1, monto: 5000, fecha: 01/01/2019, concepto: Visita a Unicentro", F.Acceso("LeerPago", "Pasajero1", "111", "1"));
    }

    @Test
    public void crearCreditoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("crearCredito", "Pasajero1", "111", "1-Pasajero1-Conductor1-10");
        assertEquals("Datos crédito{id=1, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Numero de tarjeta: ,CVV: , Fecha de Vencimiento: }\n", F.Acceso("leerEoC", "Pasajero1", "111", "Pasajero1-1"));
    }

    @Test
    public void crearEfectivoPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("crearEfectivo", "Pasajero1", "111", "2-Pasajero1-Conductor1-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        assertEquals("Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n", F.Acceso("leerEoC", "Pasajero1", "111", "Pasajero1-2"));
    }

    @Test
    public void verPermisosPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        assertEquals("CrearReserva,LeerReserva,ModificarLugarReserva,EliminarReserva,CrearPago,LeerPago,Consultar_Usuario,mod_Usuario,crearCredito,crearEfectivo,VerPagos,VerTransporte,crearTarjetaCredito,crearTarjetaDebito,ModificarTarjetaCredito,ModificarTarjetaDebito,VerViajesRealizados,VerRutas,VerAyudas,GuardarUbicaciones,CerrarSesion",
                F.Acceso("verPermisos", "Pasajero1", "111", ""));
    }

    @Test
    public void leerPagosPasajero() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("crearEfectivo", "Pasajero1", "111", "2-Pasajero1-Conductor1-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        F.Acceso("crearCredito", "Pasajero1", "111", "1-Pasajero1-Conductor2-700-CVV:1,Num:92929282882,FechaVenc:Manana");
        assertEquals("Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n"
                + "Datos crédito{id=1, nombrePasajero=Pasajero1, nombreConductor=Conductor2, monto=700.0, otros=Numero de tarjeta: ,CVV: , Fecha de Vencimiento: }\n", F.Acceso("verPagosP", "Pasajero1", "111", "Pasajero1"));
    }

    @Test
    public void leerPagosConductor() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Crear_Usuario("Pasajero2", "111", "Pasajero", "c", 3, "f", "rr", 6);
        F.Crear_Usuario("Pasajero3", "222", "Pasajero", "c", 3, "f", "rr", 7);
        F.Crear_Usuario("Conductor1", "1112", "Conductor", "c", 3, "f", "rr", 8);
        F.Acceso("crearEfectivo", "Pasajero1", "111", "2-Pasajero1-Conductor1-10-Moneda:Peso,MontoDado=20,MontoDevuelto=10");
        F.Acceso("crearEfectivo", "Pasajero2", "111", "1-Pasajero2-Conductor1-700-Moneda:Dolar,MontoDado=2000,MontoDevuelto=1300");
        F.Acceso("crearCredito", "Pasajero3", "222", "3-Pasajero3-Conductor1-700-CVV:1,Num:92929282882,FechaVenc:Manana");
        System.out.println("UUUU"+F.Acceso("verPagosC", "Conductor1", "1112", "Conductor1"));
        assertEquals(F.Acceso("verPagosC", "Conductor1", "1112", "Conductor1"), "Datos efectivo {id=2, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Moneda:Peso,MontoDado=20,MontoDevuelto=10}\n"
                + "Datos efectivo {id=1, nombrePasajero=Pasajero2, nombreConductor=Conductor1, monto=700.0, otros=Moneda:Dolar,MontoDado=2000,MontoDevuelto=1300}\n"
                + "Datos crédito{id=3, nombrePasajero=Pasajero3, nombreConductor=Conductor1, monto=700.0, otros=Numero de tarjeta: ,CVV: , Fecha de Vencimiento: }\n");

    }

    @Test
    public void verPermisosConductor() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Conductor1", "111", "Conductor", "c", 3, "f", "rr", 5);
        assertEquals("LeerPago,CrearRuta,ModificarRuta,EliminarRuta,VerRuta,VerHorario,CrearVehiculo,CerrarSesion", F.Acceso("verPermisos", "Conductor1", "111", ""));
    }

    @Test
    public void verPermisosAdmin() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Admin1", "111", "Administrador", "c", 3, "f", "rr", 5);
        assertEquals("CrearVehiculo,crearAgrupacion,AgregarAgrupacion,EliminarElemento,eliminar_Usuario,Consultar_Usuario,CerrarSesion,InmovilizarUsuario,VerTodos,ModificarNombre_Elemento,Consultar_UsuarioId", F.Acceso("verPermisos", "Admin1", "111", ""));
    }

    @Test
    public void crearVehículoAdmin() throws NoSuchMethodException {
        Facade f = new Facade();
        f.Acceso("CrearVehiculo", "hola", "123", "-NombrePrueba-Tipo-ABC123-4-Mazda-a-b");
        assertEquals("Nombre: NombrePrueba - Placa: ABC123 - Tipo: Tipo - Marca: Mazda - Referencia: b - Año: a - Cantidad de puestos: 4\n", f.Acceso("VerTransporte", "hola", "123", "NombrePrueba"));
    }

    @Test
    public void crearVehículoconCaracAdmin() throws NoSuchMethodException {
        Facade f = new Facade();
        f.Acceso("CrearVehiculo", "hola", "123", "-NombrePrueba-Tipo-ABC123-4-Mazda-a-b-10-4ruedas-a00001");
        assertEquals("Nombre: NombrePrueba - Placa: ABC123 - Tipo: Tipo - Marca: Mazda - Referencia: b - Año: a - Cantidad de puestos: 4 - Capacidad: 10 - Descripción : 4ruedas - Identificador: a00001 -\n", f.Acceso("VerTransporte", "hola", "123", "NombrePrueba"));
    }

    @Test
    public void crearAgrupacionAdmin() throws NoSuchMethodException {
        Facade f = new Facade();
        f.Acceso("crearAgrupacion", "Hola", "123", "GrupoNuevo");
        assertEquals("GrupoNuevo\n", f.Acceso("VerTransporte", "hola", "123", "GrupoNuevo"));
    }

    @Test
    public void ModificarIndividual() throws NoSuchMethodException {
        Facade f = new Facade();
        f.Acceso("CrearVehiculo", "hola", "123", "-NombrePrueba-Tipo-ABC123-4-Mazda-a-b-10-4ruedas-a00001");
        f.Acceso("ModificarIndividual", "hola", "123", "NombrePrueba;capacidad-8");
        assertEquals("Nombre: NombrePrueba - Placa: ABC123 - Tipo: Tipo - Marca: Mazda - Referencia: b - Año: a - Cantidad de puestos: 4 - Capacidad: 8 - Descripción : 4ruedas - Identificador: a00001 -\n", f.Acceso("VerTransporte", "hola", "123", "NombrePrueba"));
    }

    @Test
    public void ModificarGrupo() throws NoSuchMethodException {
        Facade f = new Facade();
        f.Acceso("crearAgrupacion", "Hola", "123", "Particular");
        f.Acceso("CrearVehiculo", "hola", "123", "Particular-NombrePrueba-Tipo-ABC123-4-Mazda-a-b-10-4ruedas-a00001");
        f.Acceso("ModificarIndividual", "hola", "123", "Particular;nombreG-Especial");
        assertEquals("Especial\n"
                + "Nombre: NombrePrueba - Placa: ABC123 - Tipo: Tipo - Marca: Mazda - Referencia: b - Año: a - Cantidad de puestos: 4 - Capacidad: 10 - Descripción : 4ruedas - Identificador: a00001 -\n\n", f.Acceso("VerTransporte", "hola", "123", "Especial"));
    }

    @Test
    public void EliminarGrupoAdmin() throws NoSuchMethodException {
        Facade f = new Facade();
        f.Acceso("crearAgrupacion", "Hola", "123", "Particular");
        f.Acceso("crearAgrupacion", "Hola", "123", "Publico");
        f.Acceso("crearAgrupacion", "Hola", "123", "Otro");
        f.Acceso("EliminarElemento", "Hola", "123", "Publico");
        assertEquals("GrupoBase\n"
                + "Particular\n"
                + "\n"
                + "Otro\n"
                + "\n"
                + "", f.Acceso("VerTransporte", "Hola", "123", "GrupoBase"));
    }

    @Test
    public void Eliminar_UsuarioAdmin() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Admin1", "111", "Administrador", 222);
        F.Crear_Usuario("Conductor1", "111", "Conductor", "c", 3, "f", "rr", 5);
        F.Acceso("eliminar_Usuario", "Admin1", "111", "Conductor1-111");
        assertEquals("", F.Acceso("Consultar_Usuario", "Admin1", "111", "Conductor1"));
    }

    @Test
    public void Ubicaciones() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("agregarUbicaciones", "Pasajero1", "111", "Pasajero1-1998-2606");
        assertEquals("1998.0/2606.0\n", F.Acceso("verUbicaciones", "Pasajero1", "111", "Pasajero1"));
    }
    @Test
    public void Tarjeta() throws NoSuchMethodException {
        Facade F = new Facade();
        F.Crear_Usuario("Pasajero1", "111", "Pasajero", "c", 3, "f", "rr", 5);
        F.Acceso("CrearTarjetaCredito", "Pasajero1", "1","Pasajero1-111-1234-Hoy");
        F.Acceso("crearCredito", "Pasajero1", "111", "0-Pasajero1-Conductor1-10");
        assertEquals("Datos crédito{id=0, nombrePasajero=Pasajero1, nombreConductor=Conductor1, monto=10.0, otros=Numero de tarjeta: 111,CVV: 1234, Fecha de Vencimiento: Hoy}\n",F.Acceso("leerEoC", "Pasajero1", "111", "Pasajero1-0"));
    }
}
