package study2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

	Scanner scanner;
	private static final String PARTICIPATEMESSAGES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요";
	private static final String HEIGHTMESSAGES = "최대 사다리 높이는 몇 개인가요?";

	public List<String> participateName() {
		System.out.println(PARTICIPATEMESSAGES);
		String str = scanner.nextLine();
		String[] name = str.split(",");
		Arrays.stream(name).forEach(s -> {
			if (s.length() > 5) {
				throw new IllegalArgumentException("이름은 최대 5자 입니다.");
			}
		});
		return Arrays.asList(name);
	}

	public int InputHeight() {
		System.out.println(HEIGHTMESSAGES);
		
		return scanner.nextInt();
	}

}
