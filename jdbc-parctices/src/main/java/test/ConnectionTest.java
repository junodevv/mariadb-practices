package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			// 1. JDBC Driver Class 로딩 - DBMS 벤더들이 만들어 놓은 클래스 모음?
			Class.forName("org.mariadb.jdbc.Driver");
			
			// 2. 연결하기 -> 드라이버가 커넥션 객체를 생성해서 나한테 주는 것
			String url = "jdbc:mariadb://192.168.0.150:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: "+ e);
		} catch (SQLException e) {
			System.out.println("Error: "+ e);
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
