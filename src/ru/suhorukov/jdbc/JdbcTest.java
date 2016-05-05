package ru.suhorukov.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Types;

import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;

public class JdbcTest {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/orcl", "scott", "scottNew");
//			System.out.println(conn != null);
			
			Statement stat = conn.createStatement();
			String empno = "25 or 1=1";
//			ResultSet rs = stat.executeQuery("select * from emp where empno = " + empno);
//			while(rs.next()){
//				String name = rs.getString("ename");
//				Integer no = rs.getInt("empno");
//				System.out.println(no + " " + name);
//			}
			
			//select * from content where text = 'blahblah' or 1 = 1
			PreparedStatement preparedStatemenet = conn.prepareStatement("select * from emp"); 
//					conn.prepareStatement("select * from emp where empno = ?");
//			preparedStatemenet.setInt(1, 12);
			ResultSet rs = preparedStatemenet.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while(rs.next()){
				for (int i = 1; i <= rsmd.getColumnCount(); i++){
//					Object obj = rs.getObject(i);
					Object obj = null;
					switch(rsmd.getColumnType(i)){
						case Types.VARCHAR : obj = rs.getString(i); break;
						case Types.NUMERIC : obj = rs.getBigDecimal(i); break;
						case Types.DATE : obj = rs.getDate(i); break;
						default : obj = rs.getObject(i);
					}
					System.out.print(obj + ";");
				}
//				String name = rs.getString("ename");
//				Integer no = rs.getInt("empno");
				System.out.println();
			}
			DatabaseMetaData dbmd = conn.getMetaData();
			conn.setAutoCommit(false);
			try {
				// stat1.execute()
				Savepoint savepoint1 = conn.setSavepoint("transaction1");
				// stat2.executeQuery()
				Savepoint savepoint2 = conn.setSavepoint("transaction2");
				// stat3.execute()
				Savepoint savepoint3 = conn.setSavepoint("transaction3");
				if (true){
					conn.rollback(savepoint2);
				}
				else {
					conn.rollback(savepoint3);
				}
				conn.commit();
			}
			catch(Exception e){
				conn.rollback();
			}
			
//			CallableStatement callableStatement = conn.prepareCall("{call raise_application_error(?, ?)}");
//			callableStatement.setInt(1, -20010);
//			callableStatement.setString(2, "Вылетела птичка!!");
//			callableStatement.execute();
//			
			
			
//			stat.execute("insert into emp(empno, ename) values (25, 'IvanovIvan')");
			
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
