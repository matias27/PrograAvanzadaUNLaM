package selMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class MatrizMath {
	/* VARIABLES */
	
	private int filas;
	private int columnas;
	private double[][] matriz;
	
	/* CONSTRUCTORES */
	
	public MatrizMath(int filas, int columnas) {
		this.filas = filas;
		this.columnas = columnas;
		this.matriz = new double [filas] [columnas];
		for(int i = 0; i < this.filas; i++){
			for(int j = 0; j < this.columnas ; j++ ){
				 this.matriz[i][j] = 0;
			}
		}
	}
	
	public MatrizMath(String path) throws FileNotFoundException, IOException {
		Locale.setDefault(new Locale("en","US"));
		Scanner sc = new Scanner(new File(path));		
		int auxFila, auxColumna;
		
		this.filas = sc.nextInt();
		this.columnas = sc.nextInt();
		this.matriz = new double [filas] [columnas];
		
		while(sc.hasNext()){
			auxFila = sc.nextInt();
			auxColumna = sc.nextInt();
			this.matriz[auxFila][auxColumna] = sc.nextDouble();
		}
		
		/*
		for(int i = 0; i < this.filas; i++){
			for(int j=0; j < this.columnas; j++){
				this.matriz[i][j] = sc.nextDouble();
			}
		*/
		sc.close();
	}
	
	/* GETTERS */
	public double[][] getMatriz() {
		return matriz;
	}	
	
	public double getValorMatriz(int fila, int columna) {
		return this.matriz[fila][columna];
	}
	
	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}

	public void mostrar(){
		System.out.println(this.filas+" "+this.columnas);
		for (int i=0; i<this.filas;i++){
			for(int j=0; j<this.columnas;j++){
				System.out.println(i+" "+j+" "+this.matriz[i][j]);
			}
		}
	}
	/* CLONE */ 	
	public MatrizMath clone(){
		MatrizMath obj = new MatrizMath (this.filas,this.columnas);
		for(int i = 0; i < this.filas; i++)
			for(int j=0;j<this.columnas;j++)
				obj.matriz[i][j] = this.matriz[i][j];
		return obj;
	}
	
	/* SETTERS */
	public void setValorMatriz(int fila, int columna, double valor) {
		this.matriz[fila][columna] = valor;
	}
	
	/* METODOS*/
	
	public MatrizMath sumar (MatrizMath m) throws Exception {
		if(this.filas != m.filas || this.columnas != m.columnas)
			throw new Exception ("Distinta dimensión");
		else {
			MatrizMath aux = new MatrizMath(this.filas, this.columnas);
			for (int i=0 ; i < this.filas ; i++){
				for(int j=0 ; j < this.columnas ; j++){
					aux.matriz[i][j] = this.matriz[i][j] + m.matriz[i][j];
				}
			}
			return aux;
		}	
	}
	


	public MatrizMath restar (MatrizMath m) throws Exception {
		if(this.filas != m.filas || this.columnas != m.columnas)
			throw new Exception ("Distinta dimensión");
		else {
			MatrizMath aux = new MatrizMath(this.filas, this.columnas);
			for (int i=0 ; i < this.filas ; i++){
				for(int j=0 ; j < this.columnas ; j++){
					aux.matriz[i][j] = this.matriz[i][j] - m.matriz[i][j];
				}
			}
			return aux;
		}	
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrizMath other = (MatrizMath) obj;
		if (columnas != other.columnas)
			return false;
		if (filas != other.filas)
			return false;
		if (!Arrays.deepEquals(matriz, other.matriz))
			return false;
		return true;
	}

	
	
	public VectorMath productoPorVector (VectorMath v) throws Exception {
		if(this.columnas != v.getDim())
			throw new Exception ("Distinta dimensión. Imposible realizar el producto.");
		else {
			VectorMath aux = new VectorMath (this.filas);
			int i = 0, j = 0, k = 0;			
			for (i=0 ; i < aux.getDim(); i++){
				for(j=0 ; j < 1 ; j++){
					double suma = 0;
					for(k=0; k < this.columnas; k++){
						suma += this.matriz[i][k] * v.getVectorValor(k);
					}
					aux.setVectorValor(i, suma);					
				}
			}
			return aux;
		}	
	}
	
	public MatrizMath productoPorMatriz (MatrizMath m) throws Exception {
		if(this.columnas != m.filas)
			throw new Exception ("Distinta dimensión. Imposible realizar el producto.");
		else {
			MatrizMath aux = new MatrizMath (this.filas,m.columnas);
			int i = 0, j = 0, k = 0;			
			for (i=0 ; i < aux.filas ; i++){
				for(j=0 ; j < aux.columnas ; j++){
					double suma = 0;
					for(k=0; k < this.columnas; k++){
						suma+=this.matriz[i][k] * m.matriz[k][j];
					}
					aux.matriz[i][j] = suma;
				}
			}
			return aux;
		}	
	}	
	
	public MatrizMath traspuesta() throws Exception {
		MatrizMath aux = new MatrizMath(this.columnas, this.filas);
		for(int i = 0 ; i < this.columnas ; i++)
			for(int j = 0; j < this.filas ; j++)
				aux.matriz[i][j] = this.matriz[j][i];				
		return aux;
	}
	
	public double determinante() throws Exception
	{
		double det = 0;
		if(this.filas == this.columnas)		{
			for(int i = 0; i < this.filas ; i++){
				double detA = 1, detB = 1;
				for(int j = 0; j < this.filas ; j++)				{
					detA *= this.matriz[j][(i + j) % this.filas];
					detB *= this.matriz[j][((this.filas + this.columnas - 1) - i - j) % this.filas];
				}
				det += detA - detB;
			}
		}
		else		{
			throw new Exception("No se puede calcular la determinante de una matriz no cuadrada.");
		}
		
        return det;
    }
	
	/* NO OBLIGATORI PERO NECESARIO LCDTM*/ 
	public MatrizMath identidad() throws Exception{
		MatrizMath aux = new MatrizMath(this.filas, this.columnas);
		for(int i = 0 ; i < aux.filas ; i++){
			for(int j = 0; j < aux.columnas ; j++){
				 if(i == j){
					 aux.matriz[i][j] = 1;
				 } else {
					 aux.matriz[i][j] = 0;
				 }
			}
		}
		return aux;
	}
	
	
	/* VER COMO MIERDA SE RESUELVE*/ 
	public MatrizMath inversa() throws Exception {
		MatrizMath auxA = this.clone();
		MatrizMath auxB = this.identidad();
		double valAux;
		if(this.filas != this.columnas)
			throw new Exception ("El nro de filas debe ser igual al nro de columnas.");
		for(int i = 0 ; i < this.filas ; i++){
			valAux = 1;
			for(int j = 0; j < this.columnas ; j++){
				if(i == j){
					valAux = this.matriz[i][j];
				}
				// MODIFICO LA COPIA DE THIS
				auxA.matriz[i][j] = auxA.matriz[i][j]/valAux;
				// MODIFICO LA IDENTIDAD PARA OBTENER LUEGO EL RESULTADO
				auxB.matriz[i][j] = auxB.matriz[i][j]/valAux;
			}
		}
		return auxB;
	}
	
	/* Normas */
	
	public double normaUno(){
		double maximo = 0;
		double valor;
		for (int j = 0; j < this.filas; j++) {
			valor = 0;
			for (int i = 0; i < this.columnas; i++) {
				valor += Math.abs(this.getValorMatriz(i, j));
				if (valor > maximo)
					maximo = valor;
			}
		}
		return maximo;
	}
	
	public double normaDos() {
		double resultado = 0;
		for (int i = 0; i < this.filas; i++)
			for (int j = 0; j < this.columnas; j++)
				resultado += getValorMatriz(i, j) * getValorMatriz(i, j);
		return Math.sqrt(resultado);
	}
	
	public double normaInfinito() {
		double maximo = 0;
		double valor;
		for (int i = 0; i <this.filas; i++) {
			valor = 0;
			for (int j = 0; j < this.columnas; j++) {
				valor += Math.abs(getValorMatriz(i, j));
				if (valor > maximo)
					maximo = valor;
			}
		}
		return maximo;
	}
	
	
}

