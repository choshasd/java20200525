import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ex01 {
	Ex01(){
//		d:\\ �ι��������
//		scan�� ���������� ����Ǿ ����ó�� try�ۿ� null�� ����
		Scanner scan = null;
		String temp = null;
		int sum = 0;
		try {
			scan = new Scanner(new File("d:\\a.txt"));
			while((temp = scan.next()) != null) {
//				System.out.println("a.txt = "+temp);
//				C#���� tryParse, as is temp
				try {
					int intValue = Integer.parseInt(temp);
					sum += intValue;
				}catch(Exception e) {
					System.out.println(temp);
					System.out.println("���ڴ� ���ڷ� ����ȯ �ȵ�");
				}
			}
		}catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
//			��� Exception ó��
		}
		System.out.println("sum = "+sum);
		System.out.println("��������");
		scan.close();
	}
	public static void main(String[] args) {
		new Ex01();
	}
}