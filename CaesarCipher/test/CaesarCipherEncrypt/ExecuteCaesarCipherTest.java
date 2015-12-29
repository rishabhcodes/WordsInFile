package CaesarCipherEncrypt;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExecuteCaesarCipherTest {
    private ExecuteCaesarCipher ce;

	@Before
	public void setUp() throws Exception {
		ce = new ExecuteCaesarCipher("me the tumee keep your tumee");
	}

	@Test
	public void test_char_frequency() {
		assertArrayEquals(new int[] {0,0,0,0,8,0,0,1,0,0,1,0,3,0,1,1,0,1,0,3,3,0,0,0,1,0}, ce.get_char_freq());
	}
	
	@Test
	public void test_get_max_char_freq(){
		assertEquals(4, ce.get_max_char_freq());
	}
	
	@Test
	public void test_simple_test(){
		assertArrayEquals(new String[] {"Me the tumee, keep your tumee", "Ew lzw lmeww, cwwh qgmj lmeww", "Me the tumee, keep your tumee"}, ExecuteCaesarCipher.simpleTests());
	}
	

	@After
	public void tearDown() throws Exception {
	}
}