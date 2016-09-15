package chemical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class SymbolLister {

	public static void main(String[] args) {
		
		System.out.println( "symbollister 0.1");
		
		List<String> chemicals = readFile("./resources/chemical-list.txt");
		
		List<String> allSymbols = new LinkedList<String>(); 
		
		for( String chemical : chemicals ){
			
			// generate the symbols
		    List<String> symbols = ChemicalNamer.generateAllSymbols(chemical);
		    
		    String toAdd = null;
		    
		    for( String symbol : symbols ){
		    	
		    	if( !allSymbols.contains(symbol)){
		    		toAdd = symbol;
		    		break;
		    	}
		    }
		    
		    if( toAdd == null ){
		    	// we are done
		    	System.out.println("stopper:"+ chemical);
		    	break;
		    }
		    
		    System.out.println( chemical +" " + toAdd );
		    
		    allSymbols.add(toAdd);
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
