package interfaces;

import java.sql.SQLException;

public interface Structure<T> {

	public void show(int id) throws SQLException;

	public void createNew(T object) throws SQLException;

	public void mod(T object1, T object2) throws SQLException;

	public void delete(T object) throws SQLException;

	void delete(int id) throws SQLException;

	void mod(int idOld, T object) throws SQLException;
}
