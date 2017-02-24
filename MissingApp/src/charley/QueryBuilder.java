package charley;

public class QueryBuilder {

	String query;
	
	public String cityOrStateQuery(String parameter, String value) {
		if (parameter.equals("state")) {
			this.query = String.format("Select * FROM Charley WHERE State='%s'", value);
		}
		
		return this.query;
	}
	
}
