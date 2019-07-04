package ladder.view;

import java.util.Scanner;

public class InputView {
	private static Scanner scanner;

	public static String enterPlayers() {
		return stringScanner("참여할 사람 이름을 입력하세요. (이름은 쉼표(,) 구분하세요)");
	}

	public static Integer enterHeightOfLadder() {
		return integerScanner("최대 사다리 높이는 몇 개인가요?");
	}

	public static String enterResults() {
		return stringScanner("실행 결과를 입력하세요. (결과는 쉼표(,) 구분하세요)");
	}
	
	public static String ResultByInputPlayer() {
		return stringScanner("결과를 보고 싶은 사람은?");
	}

	private static Integer integerScanner(String message) {
		scanner = new Scanner(System.in);
		System.out.println(message);
		return scanner.nextInt();
	}

	private static String stringScanner(String message) {
		scanner = new Scanner(System.in);
		System.out.println(message);
		return scanner.nextLine();
	}

}
