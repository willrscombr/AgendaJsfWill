package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.NamedEvent;

import model.Contato;

@ManagedBean(name="agendaController")
@ViewScoped
public class AgendaController implements Serializable {
	
	private List<Contato> lista = new ArrayList<>();
	private Contato contato = new Contato();
	
	public AgendaController(){
		contato.setNome("teste");
	};
	
	@PostConstruct
	public void init(){
		
		Contato contato = null; 
		for (int j = 1; j < 50; j++) {
			contato = new Contato();
			contato.setId(j);
			contato.setNome("Wilton");
			contato.setTelefone("064992345905");
			contato.setEndereco("Rua 7 de Setembro nº 173");
			contato.setCidade("Iporá");
			contato.setEstado("GO");
			lista.add(contato);
			
		
			
		}
		
		System.out.println("Nome: "+lista.get(48).getNome());
	}
	
	
	public List<Contato> getLista(){
		return this.lista;
	}
	
	public Contato getContato() {
		return contato;
	}


	public void setContato(Contato contato) {
		this.contato = contato;
	}


	public void salvarContato(){
		System.out.println(this.contato.getNome());
	}
	public void selecionarUmContato(Contato contato){
		this.contato = contato;
	}

}
