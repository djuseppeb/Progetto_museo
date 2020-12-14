package database;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	
	public static List<Opera> getList(){
		ArrayList<Opera> lista = new ArrayList<>();
		int i = 1;
		Creator getter = new OperaCreator();
		Opera opera = (Opera) getter.createComponent(i);
		
		while(opera != null){
	
			lista.add(opera);
			i++;
			if (i>20)
				break;
			opera = (Opera) getter.createComponent(i);
			
		};
		
		
		return lista;
	}
}
