package charley;

import java.sql.*;
import java.util.*;

public class QueryHandler {

	public ResultSet processQuery(String sql) {
		
		DBConnector db = new DBConnector();
		Connection conn;
		ResultSet result = null;
		
		try {
			conn = db.getConnection();
			Statement stmnt = conn.createStatement();
			result = stmnt.executeQuery(sql);		
		} catch(Exception e) {
			System.out.println(e);
			System.exit(1);	
		}
		return result;
		
	}
	
	public List<List> convertResultsToList(ResultSet results) {
		
		List<List> listOfResultLists = new ArrayList<List>();
		
		try {
			while (results.next()) {
				List<Object> resultsList = new ArrayList<Object>();
				resultsList.add(results.getString("Name"));
				resultsList.add(results.getString("City"));
				resultsList.add(results.getInt("Age"));
				resultsList.add(results.getString("URL"));
				listOfResultLists.add(resultsList);
			}
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
		return listOfResultLists;
	}
}
