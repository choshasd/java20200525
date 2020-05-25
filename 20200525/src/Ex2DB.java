import java.sql.Connection; 				// ���� ���� ��ü
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
// java oracle
// ms c# sqlserver
// php mysql

public class Ex2DB {
	
	Ex2DB(){
		Scanner scan = new Scanner(System.in);
		System.out.println("a�� �� = ");
		String a = scan.nextLine();
		System.out.println("b�� �� = ");
		String b = scan.nextLine();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","1234");
			pstmt = conn.prepareStatement("insert into a " + "(aa, bb) " + "values " + "('"+a+"','"+b+"')");
			
			// insert update delete�� executeUpdate�� ����
			// select�� executeQuery�� ����
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
