package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contato;

public class Contatodb {
	
	public static boolean save(Contato contato){
		System.out.println("Contatodb.save()");
		String sql = null;
		
		try {
			sql = "Insert into contato(nome,telefone,endereco,cidade,estado) values"
					+ " (?,?,?,?,?)";
			Connection con = Conexao.obterConecao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,contato.getNome());
			ps.setString(2,contato.getTelefone());
			ps.setString(3,contato.getEndereco());
			ps.setString(4,contato.getCidade());
			ps.setString(5,contato.getEstado());
			ps.executeUpdate();
			System.out.println("Salvo no banco de dados");
			return true;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	public static boolean alterar (Contato contato){
		System.out.println("Contatodb.save()");
		String sql = null;
		
		try {
			sql = "update contato set nome = ?, telefone = ?, endereco = ?, cidade = ², estado = ?, where contato.id = ?";
					
			Connection con = Conexao.obterConecao();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,contato.getNome());
			ps.setString(2,contato.getTelefone());
			ps.setString(3,contato.getEndereco());
			ps.setString(4,contato.getCidade());
			ps.setString(5,contato.getEstado());
			ps.executeUpdate();
			System.out.println("Salvo no banco de dados");
			return true;
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	public static Contato find(Integer id){
		try {
			ResultSet rs = null;
			Connection con = Conexao.obterConecao();
			String sql = "select * from contato where contato.id = "+id;
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			Contato contato = new Contato();
			while(rs.next()){
			System.out.println("contato: "+rs.getInt("id"));
			contato.setId(rs.getInt("id"));
			contato.setNome(rs.getString("nome"));
			contato.setTelefone(rs.getString("telefone"));
			contato.setEndereco(rs.getString("endereco"));
			contato.setCidade(rs.getString("cidade"));
			contato.setEstado(rs.getString("estado"));
			}
			return contato;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			
			
		}
		
		
		
	}
	
	public static List<Contato> selectAll(){
			List<Contato> lista = new ArrayList<>();
			Contato contato = null;
		
		try {
			ResultSet rs = null;
			Connection con = Conexao.obterConecao();
			String sql = "select * from contato";
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next()){
				contato = new Contato();
				
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setTelefone(rs.getString("telefone"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setCidade(rs.getString("cidade"));
				contato.setEstado(rs.getString("estado"));
				lista.add(contato);
				System.out.println(contato.getNome());
			}
			
			return lista;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}finally {
			lista = null;
			contato = null;
		}
		
		
	}
	public static void excluir(Integer id) {
		try {
			Connection con = Conexao.obterConecao();
			String sql = "delete from contato where contato.id = "+id;
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			System.out.println("excluido");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}finally {
			
			
		}
		
	}
}
