
public class Ex03 {
	Ex03(){
		doA();
		System.out.println("정상종료");
		
		try {			
			doB();
		}catch( Exception e ) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Ex03();
	}
	public static void doA() {
		doB();
	}
	public static void doB() {
		int a = 10;
		int b = 0;
		System.out.println(a/b);
//		throw new Exception("내가 만든 예외");
	}
}
