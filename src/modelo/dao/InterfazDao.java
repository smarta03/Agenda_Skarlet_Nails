package modelo.dao;

import java.util.List;

public interface InterfazDao<T> {
	List<T> recogerLista() throws Exception;
	void insertar(T t) throws Exception;
	void eliminar(T t) throws Exception;
}
