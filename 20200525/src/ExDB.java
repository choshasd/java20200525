import java.sql.Connection; 				// 연결 유지 객체
import java.sql.DriverManager;
import java.sql.PreparedStatement; 	// sql 담는 객체
import java.sql.ResultSet; 				// table 내용 담는 객체

public class ExDB {
	
	ExDB(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 예외가 나오는지 관찰하는 영역
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 찾아서 없으면 예외발생 
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			pstmt = conn.prepareStatement("select * from a");
			rs = pstmt.executeQuery();
			
//			rs.next();
//			System.out.println("111 rs.get(1) = "+rs.getString(1));
//			System.out.println("111 rs.get(2) = "+rs.getString(2));
//			
//			rs.next();
//			System.out.println("222 rs.get(1) = "+rs.getString(1));
//			System.out.println("222 rs.get(2) = "+rs.getString(2));
//			
			while(rs.next()) {
				System.out.println("rs.getString(1) = "+rs.getString(1));
				System.out.println("rs.getString(2) = "+rs.getString(2));
			}
			System.out.println("DB Connection Success !");
		}catch (Exception e) {
			// 예외 발생했을 때 처리하는 영역
		}finally {
			// 예외가 발생하든 함수가 종료되는 무조건 실행하는 영역
			try {
				if(conn != null) {
					conn.close();
				}
				if(rs != null ) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new ExDB();
	}
}
