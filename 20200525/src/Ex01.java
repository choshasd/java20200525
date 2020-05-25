import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex01 {
	Ex01(){
//		d:\\ 두번써줘야함
//		scan이 지역변수로 선언되어서 위에처럼 try밖에 null로 선언
		Scanner scan = null;
		String temp = null;
		int sum = 0;
		try {
			scan = new Scanner(new File("d:\\a.txt"));
			while((temp = scan.next()) != null) {
//				System.out.println("a.txt = "+temp);
//				C#에선 tryParse, as is temp
				try {
					int intValue = Integer.parseInt(temp);
					sum += intValue;
				}catch(Exception e) {
					System.out.println(temp);
					System.out.println("문자는 숫자로 형변환 안됨");
				}
			}
		}catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
//			모든 Exception 처리
		}
		System.out.println("sum = "+sum);
		System.out.println("정상종료");
		scan.close();
	}
	public static void main(String[] args) {
		new Ex01();
	}
}
