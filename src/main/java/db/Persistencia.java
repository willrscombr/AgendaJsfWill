package db;

public interface Persistencia<T> {
	
	public boolean salvar(Class classe,T objeto);
	public boolean alterar(Class classe, T objeto,Integer id);
	public boolean excluir(Class classe, T objeto, Integer id);
	public T find(Class classe, T objeto, Integer id);

}
