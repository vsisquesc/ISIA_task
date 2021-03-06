/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matrices;

import java.awt.Dimension;
import java.util.Random;

/**
 *
 * @author galvez
 */
public class Matriz {
    private int[][]datos;
    private Random rnd = new Random();
    
    public Matriz(int filas, int columnas, boolean inicializarAleatorio){
        setDatos(new int[columnas][]);
        for(int i=0; i<columnas; i++){
            getDatos()[i] = new int[filas];
            if (inicializarAleatorio)
                for(int j=0; j<filas; j++)
                    getDatos()[i][j] = rnd.nextInt(100);
        }
    }
    public Matriz(Dimension d, boolean inicializarAleatorio){
        this(d.height, d.width, inicializarAleatorio);
    }
    
    public Dimension getDimension(){
        return new Dimension(getDatos().length, getDatos()[0].length);
    }
    
    public static Matriz sumarDosMatrices(Matriz a, Matriz b) throws DimensionesIncompatibles { 
        if(! a.getDimension().equals(b.getDimension())) throw new DimensionesIncompatibles("La suma de matrices requiere matrices de las mismas dimensiones");        
        int i, j, filasA, columnasA; 
        filasA = a.getDimension().height; 
        columnasA = a.getDimension().width; 
        Matriz matrizResultante = new Matriz(filasA, columnasA, false);
        for (j = 0; j < filasA; j++) { 
            for (i = 0; i < columnasA; i++) { 
                matrizResultante.getDatos()[i][j] += a.getDatos()[i][j] + b.getDatos()[i][j]; 
            } 
        } 
        return matrizResultante; 
    } 


    public static Matriz multiplicarDosMatrices(Matriz mat1, Matriz mat2) throws DimensionesIncompatibles {      
        int r1 = mat1.getDimension().height; 
        int c1 = mat1.getDimension().width; 
        int r2 = mat2.getDimension().height; 
        int c2 = mat2.getDimension().width; 
        if(c1 !=r2) throw new DimensionesIncompatibles("Para poder multiplicar matrices es necesario que la matriz A tenga dimensi??n mxn y la matriz B dimensi??n nxp. El resultado tendr?? dimensi??n mxp");   
        Matriz matrizResultante = new Matriz(r1, c2, false);
        for(int i = 0; i < r1; i++) {
            for(int j = 0; j < c2; j++) { 
                for(int k = 0; k < r2; k++) {
                    matrizResultante.getDatos()[j][i] += mat1.getDatos()[k][i] * mat2.getDatos()[j][k];
                } 
            }
        }
        return matrizResultante;
    }
    

    public static Matriz transponerMatriz(Matriz a) {      
        int r = a.getDimension().height; 
        int c = a.getDimension().width; 
        Matriz matrizResultante = new Matriz(c, r, false);
        for (int j = 0; j < r; j++) { 
            for (int i = 0; i < c; i++) { 
                matrizResultante.getDatos()[j][i] += a.getDatos()[i][j]; 
            } 
        } 
        return matrizResultante; 
    }


    @Override
    public String toString(){
        String ret = "";
        ret += "[\n";
        for (int i = 0; i < getDimension().width; i++) {
            ret += "(";
            for (int j = 0; j < getDimension().height; j++) {  
                ret += String.format("%3d", getDatos()[i][j]); 
                if (j != getDimension().height - 1) ret += ", ";
            } 
            ret += ")";
            if (i != getDimension().width - 1) ret += ",";
            ret += "\n";
        } 
        ret += "]\n";
        return ret;
    }
	public int[][] getDatos() {
		return datos;
	}
	public void setDatos(int[][] datos) {
		this.datos = datos;
	}
}
