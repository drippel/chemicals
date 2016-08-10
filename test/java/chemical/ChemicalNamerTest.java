package chemical;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ChemicalNamerTest {

	@Test
	public void test_1() {
		assertTrue("Ee is valid", ChemicalNamer.isValidSymbol("Spenglerium", "Ee"));
	}

	@Test
	public void test_2() {
		assertTrue("Zr is valid", ChemicalNamer.isValidSymbol("Zeddemorium", "Zr"));
	}

	@Test
	public void test_3() {
		assertTrue("Kn is valid", ChemicalNamer.isValidSymbol("Venkmine", "Kn"));
	}

	@Test
	public void test_4() {
		assertFalse("Zt is invalid", ChemicalNamer.isValidSymbol("Stantzon", "Zt"));
	}

	@Test
	public void test_5() {
		assertFalse("Nn is invalid", ChemicalNamer.isValidSymbol("Melintzum", "Nn"));
	}

	@Test
	public void test_6() {
		assertFalse("Ty is invalid", ChemicalNamer.isValidSymbol("Tullium", "Ty"));
	}
	
	@Test 
	public void test_no_of_symbols(){
		
		List<String> symbols = ChemicalNamer.generateValidSymbols("Zuulon");
		assertTrue("should be 11", symbols.size() == 11 );
	}

	@Test 
	public void test_first_symbol_1(){
		assertTrue("should be Ei", "Ei".equals(ChemicalNamer.firstValidSymbol("Gozerium")));
	}

	@Test 
	public void test_first_symbol_2(){
		assertTrue("should be Ie", "Ie".equals(ChemicalNamer.firstValidSymbol("Slimyrine")));
	}
}
