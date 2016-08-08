package db;

public abstract class Dao<T> implements Persistencia<T> {
	
	@Override
	public boolean salvar(Class classe, T objeto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterar(Class classe, T objeto, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean excluir(Class classe, T objeto, Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T find(Class classe, T objeto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
