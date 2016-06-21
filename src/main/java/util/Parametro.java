package util;

import javax.faces.context.FacesContext;

public class Parametro {

	public Parametro() {
		
		
	}
	
	public static String getParamentro(String param){
		String s = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get( param );
		
	return s;
	}

}
