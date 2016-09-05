package selMath ;
import org.junit.Test;
import java.io.IOException;
import org.junit.Assert;

public class VectorMathTest {
	
	@Test	
	/* TEST NORMA DOS*/
	public void testNormaDos() throws Exception, IOException {
		String path = "papo.in";
		VectorMath v1 = new VectorMath(path);				
		Assert.assertEquals(5.29,v1.normaDos(),2); 
		String path2 = "testVectorConValoresNegativos.in";
		VectorMath v2 = new VectorMath(path2);	
		Assert.assertEquals(5.291502622,v2.normaDos(),0.0001);		
		String path3 = "testVectorConDecimales.in";
		VectorMath v3 = new VectorMath(path3);	
		Assert.assertEquals(5.930578724,v3.normaDos(),0.00001);
	}
	
	@Test
	public void testNormaUno() throws Exception, IOException {
		
		String path = "papo.in";
		VectorMath v1 = new VectorMath(path);				
		Assert.assertEquals(12,v1.normaUno(),0);
		String path2 = "testVectorConValoresNegativos.in";
		VectorMath v2 = new VectorMath(path2);	
		Assert.assertEquals(12,v2.normaUno(),0);		
		String path3 = "testVectorConDecimales.in";
		VectorMath v3 = new VectorMath(path3);	
		Assert.assertEquals(13.578,v3.normaUno(),0.00001);
		
		
	}
	
}

