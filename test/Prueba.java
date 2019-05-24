/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Composite.Individual;
import Composite.MedioTransporte;
import Composite.Transporte;
import Decorator.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Pedro de Jesús
 */
public class Prueba {

    public Prueba() {
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
    public void ConsutarPorNombreIndividual() {
        MedioTransporte aMT = new MedioTransporte("aMT");
        Transporte aN = new Individual("aN", "aT", "aP", "1", "aM", "aA", "aR");
        aMT.Crear(aN);
        assertEquals(aMT.ConsultarNombre("aN"), "Nombre: aN - Placa: aP - Tipo: aT - Marca: aM - Referencia: aR - Año: aA - Cantidad de puestos: 1\n");
    }

    @Test
    public void ConsutarPorNombreIndividualConCarac() {
        MedioTransporte aMT = new MedioTransporte("bMT");
        Transporte aN = new IdentificadorDecorator("A0000001", new DescripcionDecorator("4 ruedas", new CapacidadDecorator(8, new Individual("Carro", "Automovil", "AAA123", "5", "Nissan", "2012", "Versa"))));
        aMT.Crear(aN);
        assertEquals(aMT.ConsultarNombre("Carro"), "Nombre: Carro - Placa: AAA123 - Tipo: Automovil - Marca: Nissan - Referencia: Versa - Año: 2012 - Cantidad de puestos: 5 - Capacidad: 8 - Descripción : 4 ruedas - Identificador: A0000001 -\n");
    }

    @Test
    public void ConsultarDatosGrupo() {
        MedioTransporte aMT = new MedioTransporte("aMT");
        MedioTransporte bMT = new MedioTransporte("bMT");
        Transporte aN = new Individual("aN", "aT", "aP", "1", "aM", "aA", "aR");
        Transporte bN = new Individual("bN", "bT", "bP", "2", "bM", "bA", "bR");
        aMT.Crear(bMT);
        bMT.Crear(aN);
        bMT.Crear(bN);
        assertEquals(aMT.ConsultarNombre("bMT"), "bMT\n"
                + "Nombre: aN - Placa: aP - Tipo: aT - Marca: aM - Referencia: aR - Año: aA - Cantidad de puestos: 1\n"
                + "Nombre: bN - Placa: bP - Tipo: bT - Marca: bM - Referencia: bR - Año: bA - Cantidad de puestos: 2\n\n");
    }

    @Test
    public void ConsultarDatosGrupoGrupo() {
        MedioTransporte aMT = new MedioTransporte("aMT");
        MedioTransporte bMT = new MedioTransporte("bWT");
        MedioTransporte cMT = new MedioTransporte("cXT");
        Transporte aN = new Individual("aN", "aT", "aP", "1", "aM", "aA", "aR");
        Transporte bN = new Individual("bN", "bX", "bP", "2", "bM", "bA", "bR");
        Transporte cN = new Individual("cN", "cX", "cP", "3", "cM", "cA", "cR");
        aMT.Crear(bMT);
        aMT.Crear(cMT);
        bMT.Crear(aN);
        bMT.Crear(bN);
        cMT.Crear(cN);
        assertEquals(aMT.ConsultarNombre("aMT"), "aMT\n"
                + "bWT\n"
                + "Nombre: aN - Placa: aP - Tipo: aT - Marca: aM - Referencia: aR - Año: aA - Cantidad de puestos: 1\n"
                + "Nombre: bN - Placa: bP - Tipo: bX - Marca: bM - Referencia: bR - Año: bA - Cantidad de puestos: 2\n"
                + "\n"
                + "cXT\n"
                + "Nombre: cN - Placa: cP - Tipo: cX - Marca: cM - Referencia: cR - Año: cA - Cantidad de puestos: 3\n\n");
    }

    @Test
    public void ModificarIndividual() {
        MedioTransporte aMT = new MedioTransporte("bMT");
        Transporte aN = new IdentificadorDecorator("A0000001", new DescripcionDecorator("4 ruedas", new CapacidadDecorator(8, new Individual("Carro", "Automovil", "AAA123", "5", "Nissan", "2012", "Versa"))));
        aMT.Crear(aN);
        aMT.cambiarAtributo("Carro;descripcion", "4 ruedas y 1 de repuesto");
        aMT.cambiarAtributo("Carro;capacidad", "4");
        assertEquals(aMT.ConsultarNombre("Carro"), "Nombre: Carro - Placa: AAA123 - Tipo: Automovil - Marca: Nissan - Referencia: Versa - Año: 2012 - Cantidad de puestos: 5 - Capacidad: 4 - Descripción : 4 ruedas y 1 de repuesto - Identificador: A0000001 -\n");
    }

    @Test
    public void ModificarGrupo() {
        MedioTransporte aMT = new MedioTransporte("aMT");
        MedioTransporte bMT = new MedioTransporte("bMT");
        Transporte aN = new Individual("aN", "aT", "aP", "1", "aM", "aA", "aR");
        Transporte bN = new Individual("bN", "bT", "bP", "2", "bM", "bA", "bR");
        aMT.Crear(bMT);
        bMT.Crear(aN);
        bMT.Crear(bN);
        aMT.cambiarAtributo("bMT;nombreG", "TnT");
        assertEquals(aMT.ConsultarNombre("bMT"), "");
    }

    @Test
    public void ModificarGrupoGrupo() {
        MedioTransporte aMT = new MedioTransporte("aMT");
        MedioTransporte bMT = new MedioTransporte("bMT");
        Transporte aN = new Individual("aN", "aT", "aP", "1", "aM", "aA", "aR");
        Transporte bN = new Individual("bN", "bT", "bP", "2", "bM", "bA", "bR");
        aMT.Crear(bMT);
        bMT.Crear(aN);
        bMT.Crear(bN);
        aMT.cambiarAtributo("nombreG", "TnT");
        assertEquals(aMT.ConsultarNombre("aMT"), "");
    }

    @Test
    public void EliminarIndividual() {
        MedioTransporte aM = new MedioTransporte("aM");
        MedioTransporte aMT = new MedioTransporte("aMT");
        Transporte aN = new Individual("aN", "aT", "aP", "1", "aM", "aA", "aR");
        Transporte bN = new Individual("bN", "bT", "bP", "2", "bM", "bA", "bR");

        aM.Crear(aMT);
        aMT.Crear(aN);
        aMT.Crear(bN);

        aMT.Eliminar(bN);

        assertEquals(aM.ConsultarNombre("aMT"), "aMT\n"
                + "Nombre: aN - Placa: aP - Tipo: aT - Marca: aM - Referencia: aR - Año: aA - Cantidad de puestos: 1\n\n");
    }

    @Test
    public void EliminarGrupo() {
        MedioTransporte aM = new MedioTransporte("aM");
        MedioTransporte aMT = new MedioTransporte("aMT");
        Transporte aN = new Individual("aN", "aT", "aP", "1", "aM", "aA", "aR");
        Transporte aaN = new Individual("aaN", "aaT", "aaP", "2", "aaM", "aaA", "aaR");

        MedioTransporte bMT = new MedioTransporte("bMT");
        Transporte bN = new Individual("bN", "bT", "bP", "3", "bM", "bA", "bR");
        Transporte bbN = new Individual("bbN", "bbT", "bbP", "4", "bbM", "bbA", "bbR");

        aM.Crear(aMT);
        aMT.Crear(aN);
        aMT.Crear(aaN);
        aMT.Crear(bMT);

        bMT.Crear(bN);
        bMT.Crear(bbN);

        aMT.Eliminar(bMT);
        assertEquals(aM.ConsultarNombre("aM"), "aM\n"
                + "aMT\n"
                + "Nombre: aN - Placa: aP - Tipo: aT - Marca: aM - Referencia: aR - Año: aA - Cantidad de puestos: 1\n"
                + "Nombre: aaN - Placa: aaP - Tipo: aaT - Marca: aaM - Referencia: aaR - Año: aaA - Cantidad de puestos: 2\n\n");
    }

}
