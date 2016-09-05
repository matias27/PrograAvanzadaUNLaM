package selMath;
import org.junit.Test;
import java.io.IOException;
import org.junit.Assert;


public class MatrizMathTest {

	//@Test
	public void testProductoPorMatriz() throws Exception, IOException{
		System.out.println("TEST 1 - PRODUCTO ENTRE MATRICES");
		String path1 = "testMatrizConDecimales_1.in";
		String path2 = "testMatrizConDecimales_2.in";
		String path4 = "testMatrizConDecimales_4.in";
		MatrizMath m1 = new MatrizMath(path1);
		MatrizMath m2 = new MatrizMath(path2);
		MatrizMath mRes = new MatrizMath(path4);
		mRes.mostrar();
		m1.productoPorMatriz(m2).mostrar();
		Assert.assertEquals(mRes, m1.productoPorMatriz(m2));
	}
	
	//@Test
	public void testTraspuesta() throws Exception, IOException{
		System.out.println("TEST 2 - MATRIZ TRASPUESTA");
		String path1 = "testMatrizConDecimales_1.in";
		String path2 = "testTraspuestaResultado_1.in";
		String path3 = "testMatrizConDecimales_2.in";
		
		MatrizMath m1 = new MatrizMath(path1);
		MatrizMath m2 = new MatrizMath(path2);
		MatrizMath m3 = new MatrizMath(path3);
		
		// CASO FAVORABLE
		Assert.assertEquals(m2, m1.traspuesta());
		// CASO DESFAVORABLE
		Assert.assertNotEquals(m3, m1.traspuesta());		
	}
	
	@Test
	public void testProductoPorVector() throws Exception, IOException{
		System.out.println("TEST 3 - PRODUCTO ENTRE MATRIZ Y VECTOR");
		String path1 = "testMatriz001.in";
		String path2 = "testVector001.in";
		String path3 = "testVector002.in";
		
		MatrizMath m1 = new MatrizMath(path1);
		VectorMath v1 = new VectorMath(path2);
		VectorMath v2 = new VectorMath(path3);
		
		m1.productoPorVector(v2).mostrar();
		System.out.println(" ");
		v2.mostrar();
		
		// CASO FAVORABLE
		Assert.assertEquals(v2, m1.productoPorVector(v1));
		// CASO DESFAVORABLE
		Assert.assertNotEquals(v2, m1.productoPorVector(v2));
	}
	
	
}
