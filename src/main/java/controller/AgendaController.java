package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.NamedEvent;

import db.Contatodb;

import model.Contato;
import util.ParamToObjeto;
import util.Parametro;

@ManagedBean(name="agendaController")
@ViewScoped
public class AgendaController implements Serializable {
	
	private List<Contato> lista =  new ArrayList<>();
	private Contato contato = new Contato();
	
	public AgendaController(){
		contato.setNome("teste");
	};
	
	@PostConstruct
	public void init(){
		System.out.println("AgendaController.init()");
				
		lista = Contatodb.selectAll();
		//acoesContato();
		
		
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
	
	public void acoesContato(){
		System.out.println("AgendaController.acoesContato()");
		try {
		this.contato = (Contato) ParamToObjeto.getObject("alterar", "Contato");
		System.out.println(this.contato.getId());
		} catch (Exception e) {
			System.err.println("acoesContato: "+e.getMessage());
		}
	}
	
	public void selecionar(Integer id){
		this.contato = Contatodb.find(id);
		System.out.println("Contato busc: "+this.contato.getNome());
	}


	public String salvarContato(){
		System.out.println("AgendaController.salvarContato()");
		Contatodb.save(this.contato);
		lista = Contatodb.selectAll();
		return "index.xhtml?faces-redirect=true";
	}
	public void selecionarUmContato(Contato contato){
		this.contato = contato;
	}
	public String excluir(Integer id){
		Contatodb.excluir(id);
		return "index.xhtml?faces-redirect=true";
	}

}
