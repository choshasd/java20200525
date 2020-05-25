import java.util.Scanner;

class MyException extends Exception{
	public MyException() {
		super("점심");
	}
}
public class Ex04 {
	Ex04(){
		try {
		Scanner scan = new Scanner(System.in);
		System.out.println("점심 뭐드실?");
		String menu = scan.nextLine();
		if(menu.contains("고기")) {
			System.out.println("정상");
		}else {
			throw new MyException();
		}
		}catch(MyException e) {
			System.out.println("고기먹어");
		}
	}
	public static void main(String[] args) throws MyException {
		new Ex04();
	}
}
