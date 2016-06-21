package util;


import db.Contatodb;


public class ParamToObjeto {
	
	/*
	 * Param é o parametro da Url
	 * Classe é o nome da classe que será retornada.
	 * 
	 * */

	public static Object getObject(String param, String classe) {
		System.out.println("ParamToObjeto.getObject()");
		String s = Parametro.getParamentro(param);
		System.out.println(s);
		Object obj = null;
		try {
			if (s == null) {
				System.err.println("Deu B.O");
				return new Object();
			} else {
				Integer codigo = Integer.valueOf(s);
				System.out.println("Param: "+param+" Class: "+classe+"Value: "+s);
				switch (classe) {
				case "Contato":
						obj = (Object) Contatodb.find(Integer.valueOf(s));
					break;
				case "CicloReprodutivo":
					
					break;

				default:

					break;
				}

			}
			return obj;
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

		
	}
}
