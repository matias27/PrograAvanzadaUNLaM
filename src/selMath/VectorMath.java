package selMath;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class VectorMath {
	
	private double vector[];
	private int dim;
	/* CONSTRUCTORES */
	public VectorMath(int dim){
		this.dim = dim;
		this.vector = new double[dim];
		for (int i=0;i<dim;i++)
			this.vector[i] = 0;
	}
	
	public VectorMath(String path) throws FileNotFoundException, IOException {
		Locale.setDefault(new Locale("en","US"));
		Scanner sc = new Scanner(new File(path));
		
		this.dim = sc.nextInt();
		this.vector = new double[dim];
		
		for(int i = 0; i < this.dim; i++)
			this.vector[i] = sc.nextDouble();
		sc.close();
	}
	
	/* METODOS */
	
	public VectorMath suma (VectorMath obj) throws Exception {
		if(obj.dim != this.dim)
			throw new Exception ("Distinta dimensión");
		else {
			VectorMath aux = new VectorMath(this.vector.length);
			for(int i =0;i < this.dim; i++){
				aux.vector[i] = this.vector[i] + obj.vector[i];
			}
			return aux;
		}
	}
	
	
	public VectorMath resta (VectorMath obj) throws Exception {
		if(obj.dim != this.dim)
			throw new Exception ("Distinta dimensión");
		else {
			VectorMath aux = new VectorMath(this.vector.length);
			for(int i =0;i < this.dim; i++){
				aux.vector[i] = this.vector[i] - obj.vector[i];
			}
			return aux;
		}
	}
	
	/* PRODUCTO ENTRE VECTORMATHS */
	
	public double producto (VectorMath obj) throws Exception {
		if(obj.dim != this.dim)
			throw new Exception ("Distinta dimensión");
		else {
			double aux = 0;
			for(int i =0;i < this.dim; i++){
				aux+= this.vector[i] * obj.vector[i];
			}
			return aux;
		}
	}
	
	/* PRODUCTO ENTRE VECTORMATH Y UN ESCALAR */
	
	public VectorMath productoVM (double escalar) throws Exception {
		VectorMath aux = new VectorMath(this.vector.length);
		for(int i =0;i < this.dim; i++)
			aux.vector[i] = this.vector[i] *escalar;
		return aux;
	}
	
	/* EQUALS (COMPARE) */
	
	
	
	//public boolean equals(VectorMath obj){
	//	if(obj.dim != this.dim)
	//		return false;
	//	for(int i = 0; i < this.dim; i++)
	//		if(this.vector[i] != obj.vector[i])
	//			return false;
	//	return true;
	//}
	
	/* CLONE */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VectorMath other = (VectorMath) obj;
		if (dim != other.dim)
			return false;
		if (!Arrays.equals(vector, other.vector))
			return false;
		return true;
	}

	public VectorMath clone(){
		VectorMath obj = new VectorMath(this.vector.length);
		for(int i = 0; i < this.dim; i++)
			obj.vector[i] = this.vector[i];
		return obj;
	}
	
	/* NORMAS DE VECTORMATH */
	
	public double normaUno (){
		
		double aux = 0;
		for (int i=0; i<this.dim; i++)
			aux += Math.abs(this.vector[i]);
		return aux;		
	}
	
	public double normaDos (){
		double aux = 0;
		for (int i = 0; i < this.dim; i++)
			aux += Math.pow(this.vector[i], 2);
		return Math.sqrt(aux);
	}
	
	/* GETTERS */	
	public double[] getVector() {
		return vector;
	}

	public double getVectorValor(int i) {
		return vector[i];
	}

	public int getDim() {
		return dim;
	}

	/* SETTERS */
	public void setVectorValor(int posicion, double dato) {
		this.vector[posicion] = dato;
	}

	
	public double normaInfinito (){
		/* VALORES */
		double maximo = 0;
		for (double valor : vector) {
			valor = Math.abs(valor);
			if (valor > maximo)
				maximo = valor;
		}
		return maximo;
	}
	
	public void mostrar(){
		System.out.println(this.dim+" 1");
		for (int i=0; i<this.dim;i++){
			System.out.println(i+" 1 "+this.vector[i]);		
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {

		Locale.setDefault(new Locale("en","US"));
	/*
		String path = "papo.in";
		String path2 = "papo.in";
		
		VectorMath v1 = new VectorMath(path);
		VectorMath v2 = new VectorMath(path2);
		
		VectorMath v3 = v1.resta(v2);
		for(int i = 0; i < v3.dim ; i++)
			System.out.println(v3.vector[i]);
		double prod = v1.producto(v2);
		System.out.println(prod);
		if(v1.equals(v2))
			System.out.println("SON IGUALES");
		else
			System.out.println("SON DISTINTOS");
		VectorMath v4 = v1.clone();
		*/
	}

}
