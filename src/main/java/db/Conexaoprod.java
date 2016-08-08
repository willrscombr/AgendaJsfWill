package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexaoprod {
	
	
	private static Connection instanciaUnica;
	
	private static Connection criarConexao() {
		try {
			Connection con = null;
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://aws-teste.cii4wufkfdbq.us-west-2.rds.amazonaws.com/agenda", "toor", "syswillaws");
			System.out.println("Conectou");
			return con;
		} catch (Exception e) {
			System.err.println("Não conectou !!!");
			System.err.println(e.getMessage());
			return null;
		}
	}
	public static Connection obterConecao() {
		if (instanciaUnica == null) {
			synchronized (Connection.class) {
				if (instanciaUnica == null) {
					instanciaUnica = criarConexao();
					System.out.println("Conexao criada");
				}
			}
		}else{
			System.out.println("COnexao ja existente");
		}
		return instanciaUnica;
	}
}
