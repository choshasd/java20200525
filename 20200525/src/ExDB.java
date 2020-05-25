import java.sql.Connection; 				// ���� ���� ��ü
import java.sql.DriverManager;
import java.sql.PreparedStatement; 	// sql ��� ��ü
import java.sql.ResultSet; 				// table ���� ��� ��ü

public class ExDB {
	
	ExDB(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// ���ܰ� �������� �����ϴ� ����
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ã�Ƽ� ������ ���ܹ߻� 
			
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
			// ���� �߻����� �� ó���ϴ� ����
		}finally {
			// ���ܰ� �߻��ϵ� �Լ��� ����Ǵ� ������ �����ϴ� ����
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
