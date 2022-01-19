package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import matrices.DimensionesIncompatibles;
import matrices.Matriz;

class tarea_2 {
	@Test
	void multiplicarExcepción() {
		Matriz m1 = new Matriz(3, 4, true);
		Matriz m2 = new Matriz(1, 5, true);
		Assertions.assertThrows(DimensionesIncompatibles.class, () -> Matriz.multiplicarDosMatrices(m1, m2));
	}
	
	@Test
	void transponerExcepción() {
		fail("Not yet implemented");
	}
	
	@Test
	void MultiplicarOK() {
		Matriz m1 = new Matriz(3, 3, false);
		Matriz m2 = new Matriz(3, 3, false);
		Matriz expected = new Matriz(3, 3, false);
		// Asignar valores a matriz m1 y matriz m2
		int[][] m1_datos = {{0,1,0},{1,3,0},{0,1,1}};
		m1.setDatos(m1_datos);
		
		int[][] m2_datos = {{0,100,2},{1,0,1},{1,1,2}};
		m2.setDatos(m2_datos);
		
		// Precalcular resultado
		int[][] expected_datos = {{100,302,2},{0,2,1},{1,6,2}};
		expected.setDatos(expected_datos);
		Matriz mult = null;
		try {
			mult = Matriz.multiplicarDosMatrices(m1, m2);
		} catch (DimensionesIncompatibles e) { 
			e.printStackTrace();
		}
		
        for (int j = 0; j < 3; j++) { 
            for (int i = 0; i < 3; i++) {  
                Assertions.assertEquals(expected.getDatos()[i][j], mult.getDatos()[i][j]);
            } 
        } 
		
	}
	
	@Test
	void TransponerOK() {		
		Matriz m1 = new Matriz(3, 3, false);
		Matriz expected = new Matriz(3, 3, false);
		// Asignar valores a matriz m1 y matriz m2
		int[][] m1_datos = {{0,1,0},{1,3,0},{0,1,1}};
		m1.setDatos(m1_datos);
		
		// Precalcular resultado
		int[][] expected_datos = {{0,1,0},{1,3,1},{0,0,1}};
		expected.setDatos(expected_datos);
		
		Matriz transposed = Matriz.transponerMatriz(m1);
	
		
	    for (int j = 0; j < 3; j++) { 
	        for (int i = 0; i < 3; i++) {  
	            Assertions.assertEquals(expected.getDatos()[i][j], transposed.getDatos()[i][j]);
	        } 
	    } 
		
	}

}
