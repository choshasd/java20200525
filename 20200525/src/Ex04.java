import java.util.Scanner;

class MyException extends Exception{
	public MyException() {
		super("����");
	}
}
public class Ex04 {
	Ex04(){
		try {
		Scanner scan = new Scanner(System.in);
		System.out.println("���� �����?");
		String menu = scan.nextLine();
		if(menu.contains("���")) {
			System.out.println("����");
		}else {
			throw new MyException();
		}
		}catch(MyException e) {
			System.out.println("���Ծ�");
		}
	}
	public static void main(String[] args) throws MyException {
		new Ex04();
	}
}
