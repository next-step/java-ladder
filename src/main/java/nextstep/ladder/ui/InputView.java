package nextstep.ladder.ui;

import java.util.Scanner;

public class InputView {
	private static final String QUESTION_OF_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String QUESTION_OF_HEIGHT = "최대 사다리 높이는 몇 개인가요?";
	private static final String QUESTION_OF_REWARDS = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
	private static Scanner scanner = new Scanner(System.in);

	private InputView() {
	}

	public static String inputParticipantNames() {
		System.out.println(QUESTION_OF_NAMES);
		return scanner.nextLine();
	}

	public static int inputMaximumHeight() {
		System.out.println(QUESTION_OF_HEIGHT);
		int input = scanner.nextInt();
		scanner.nextLine();
		return input;
	}

	public static String inputRewards() {
		System.out.println(QUESTION_OF_REWARDS);
		return scanner.nextLine();
	}

	public static String inputResultName() {
		System.out.println("결과를 보고 싶은 사람은?");
		return scanner.nextLine();
	}
}
