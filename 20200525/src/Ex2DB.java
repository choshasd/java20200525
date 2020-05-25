import java.sql.Connection; 				// 연결 유지 객체
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
// java oracle
// ms c# sqlserver
// php mysql

public class Ex2DB {
	
	Ex2DB(){
		Scanner scan = new Scanner(System.in);
		System.out.println("a의 값 = ");
		String a = scan.nextLine();
		System.out.println("b의 값 = ");
		String b = scan.nextLine();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			pstmt = conn.prepareStatement("insert into a " + "(aa, bb) " + "values " + "('"+a+"','"+b+"')");
			
			// insert update delete는 executeUpdate로 실행
			// select는 executeQuery로 실행
			pstmt.executeUpdate();
			System.out.println("DB Connection Success !");

		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new Ex2DB();
	}
}
