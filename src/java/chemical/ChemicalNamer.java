package chemical;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChemicalNamer {

	public static boolean isValidSymbol( String element, String symbol ){
		
		if( element == null || symbol == null ){
			return false;
		}

		String lelement = element.toLowerCase();
		String lsymbol = symbol.toLowerCase();
		
		
		if( lelement.length() < 2 ){
			return false;
		}
		
		if( !validLength(lsymbol)){
			return false;
		}
		
		if( !containsBothLetters(lelement, lsymbol)){
			return false;
		}

		if( !inOrder(lelement, lsymbol)){
			return false;
		}

		return true;
	}
	
	public static boolean validLength( String symbol ){
		return symbol.length() == 2;
	}
	
	public static boolean containsBothLetters( String element, String symbol ){
		
		if( element.indexOf(symbol.charAt(0)) == -1 ){
			return false;
		}

		if( element.indexOf(symbol.charAt(1)) == -1 ){
			return false;
		}
		
		return true;
	}
	
	public static boolean inOrder( String element, String symbol ){
		
		int e = element.indexOf(symbol.charAt(0));
		int s = element.indexOf(symbol.charAt(1), (e+1) );
		
		if( s == -1 ){
			return false;
		}
		
		return s > e;
		
	}
	
	public static List<String> generateValidSymbols( String element ){
		
		String lelement = element.toLowerCase();
		
		Set<String> symbols = new HashSet<String>(); 
		
		for( int outer = 0; outer < lelement.length() - 1; outer++ ){
			for( int inner = (outer + 1); inner < lelement.length(); inner++ ){
				String symbol = Character.toUpperCase(lelement.charAt(outer)) + "" + lelement.charAt(inner);
				symbols.add(symbol);
			}
		}
		
		return new ArrayList<String>( symbols );
	}

	public static List<String> generateAllSymbols( String element ){
		
		String lelement = element.toLowerCase();
		
		List<String> symbols = new ArrayList<String>(); 
		
		for( int outer = 0; outer < lelement.length() - 1; outer++ ){
			for( int inner = (outer + 1); inner < lelement.length(); inner++ ){
				String symbol = Character.toUpperCase(lelement.charAt(outer)) + "" + lelement.charAt(inner);
				symbols.add(symbol);
			}
		}
		
		return symbols;
	}

	public static List<String> sortSymbols( List<String> symbols ){
		List<String> copy = new ArrayList<String>(symbols);
		java.util.Collections.sort(copy);
		return copy;
	}
	
	public static String firstValidSymbol( String element ){
		return sortSymbols(generateValidSymbols(element)).get(0);
	}
}
