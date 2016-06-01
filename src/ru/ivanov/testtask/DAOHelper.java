package ru.ivanov.testtask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Vector;

public class DAOHelper {
	
	private static Connection connection = null;
	
	static {
		connection = ConnectionManager.getConnection();
	}
	
	public static boolean login(String userName, String password){
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement("select password from users where login = ?");
			statement.setString(1, userName);
			ResultSet rs = statement.executeQuery();	
			while(rs.next()){
				String dbPassword = rs.getString("password");
				if(dbPassword.trim().equals(password.trim())){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static boolean newAccount(String username, String password){
		return true;
	}
	
	public static DataStructure fetchData(String sql){
		Vector<String> columnNames = new Vector<String>();
		Vector<Vector<Object>> result = null;
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(sql);
			result = new Vector<Vector<Object>>();
			ResultSetMetaData rsmd = rs.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++){
				columnNames.add(rsmd.getColumnName(i));
			}
			
			while (rs.next()) {
				Vector<Object> row = new Vector<Object>();
				for(String columnName : columnNames) {
					row.add(rs.getObject(columnName));
				}
				result.add(row);
			}	
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DataStructure(columnNames, result);
	}
	
	public static void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static ResourceBundle bundle = ResourceBundle.getBundle("ru.ivanov.testtask.resource");
	
	public static String getResourceText(String keyResource){
		return bundle.getString(keyResource);
	}
}
