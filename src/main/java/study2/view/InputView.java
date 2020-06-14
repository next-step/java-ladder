package study2.view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
	
	Scanner scanner;
	private static final String participateMessage = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요"; 
	
	public String[] participateName() {
		System.out.println(participateMessage);
		String str = scanner.nextLine();
		String[] name = str.split(",");
		Arrays.stream(name).forEach(s -> {
            if(s.length() > 5) {
                throw new IllegalArgumentException();
            }
        });
		return name;
	}
	
	
	
}
