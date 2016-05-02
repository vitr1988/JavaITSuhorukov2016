package ru.suhorukov.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@//localhost:1521/orcl", "scott", "scottNew");
			System.out.println(conn != null);
			
			Statement stat = conn.createStatement();
			String empno = "25 or 1=1";
//			ResultSet rs = stat.executeQuery("select * from emp where empno = " + empno);
//			while(rs.next()){
//				String name = rs.getString("ename");
//				Integer no = rs.getInt("empno");
//				System.out.println(no + " " + name);
//			}
			
			PreparedStatement preparedStatemenet = conn.prepareStatement("select * from emp where empno = ?");
			preparedStatemenet.setInt(1, 12);
			ResultSet rs = preparedStatemenet.executeQuery();
			while(rs.next()){
				String name = rs.getString("ename");
				Integer no = rs.getInt("empno");
				System.out.println(no + " " + name);
			}
			
//			stat.execute("insert into emp(empno, ename) values (25, 'IvanovIvan')");
			
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
