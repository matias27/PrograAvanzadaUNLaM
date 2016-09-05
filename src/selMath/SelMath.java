package selMath;

import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

public class SelMath {
	private int dimension;
	private MatrizMath matriz[][];
	private VectorMath resultado[];
	
	public SelMath(String path) throws FileNotFoundException, IOException{
		Locale.setDefault(new Locale("en","US"));
		Scanner sc = new Scanner(new File(path));		
		this.dimension = sc.nextInt();
		this.matriz = new MatrizMath [this.dimension] [this.dimension];
		for(int i = 0; i<this.dimension;i++)
			for(int j = 0; j<this.dimension;j++){
				this.matriz[i][j].setValorMatriz(i,j,sc.nextDouble());
			}
		// REVISAR, NO ME GUSTA COMO QUEDA
		while(sc.hasNextInt()){
			int k=sc.nextInt();
			this.resultado[k].setVectorValor(k,k);
		}
		
		sc.close();
		
	}
	
	public void mostrarResultados(){
		for(int i=0; i<this.dimension;i++)
			for(int j=0; j<this.dimension;j++){
				System.out.print(this.matriz[i][j].getValorMatriz(i,j)+"");
			}
		
	}
	
	
}
