package chemical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class SymbolLister2 {

	public static void main(String[] args) {
		
		System.out.println( "symbollister 0.1");
		
		List<String> chemicals = readFile("./resources/chemical-list.txt");
		chemicals.stream().forEach( 
	      (String c) -> { 
			
		    List<String> symbolList = ChemicalNamer.generateAllSymbols(c); 
	        Optional<String> symbol = symbolList.stream().filter( ( String s) -> { return !symbolDefined(s); } ).findFirst();
	        if( symbol.isPresent() ){
	          addSymbol(symbol);
	        }
	        else {
	          System.out.println("stopper:" + c );
	        }
		});
		
		// symbolList.forEach( (s) -> { System.out.println(s); } );
		System.out.println( symbolList.size()  );

		
	}
	
	static List<String> symbolList = new LinkedList<String>();
	
	static boolean symbolDefined( String symbol ){
		return symbolList.contains(symbol);
	}
	
	static void addSymbol( Optional<String> symbol ){
		if( symbol.isPresent() ){
			symbolList.add(symbol.get());
		}
	}
	
	
	public static List<String> readFile( String name ){
		
		// open the file
		File f = new File(name);
		
		if( !f.exists() ){
			String msg = "file not found:"+ f ;
			System.out.println( msg );
			throw new IllegalStateException(msg);
		}
		
		try{
		  BufferedReader br = new BufferedReader( new FileReader( f ));
		  
		  List<String> symbols =  new LinkedList<String>();
		  for( String line = br.readLine(); line != null; line = br.readLine() ){
			  symbols.add(line);
		  }
		  
		  return symbols ;
		
		}
		catch( Exception e ){
			String msg = "Unepected error reading file:" + e.getMessage();
			System.out.println( msg );
			throw new IllegalStateException( msg );
		}
		
	}

}
