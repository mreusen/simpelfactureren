package nl.reusenit.simpelfactureren.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Dummy implementatie van een DAO.
 * Ten behoeve van basic Unit testen
 * 
 * @author ReusenIT
 *
 */
public class DummyDao {

	private List<String> database;
	
	public DummyDao(List<String> database) {
		this.database = database;
	}

	public void delete(String element) {
		database.remove(element);
	}
	
	public void add(String element) {
		database.add(element);
	}
	
	public List<String> find(String queryWord) {
		List<String> result = new ArrayList<String>();
		for (String element : database) {
			if (element.contains(queryWord)) {
				result.add(element);
			}
		}
		return result;
	}
}
