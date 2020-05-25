import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
// import 생성  : ctrl + shift + o

public class Ex02 {
	Ex02(){
		Path filepath = Paths.get("d:\\a.txt");
		BufferedWriter bw = null;
		
		try {
			bw = Files.newBufferedWriter(filepath);
			bw.write("aaa"); // a.txt에 내용수정
			bw.write("bbb");
			bw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(bw);
		System.out.println("정상종료");
	}
	public static void main(String[] args) {
		new Ex02();
	}
	
}
