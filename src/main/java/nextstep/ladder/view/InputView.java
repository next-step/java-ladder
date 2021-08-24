package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String MESSAGE_INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String MESSAGE_INPUT_EXPECTED_RESULTS = System.lineSeparator() + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
	private static final String MESSAGE_INPUT_LADDER_HEIGHT = System.lineSeparator() + "최대 사다리 높이는 몇 개인가요?";

	private InputView() {
	}

	public static String inputPlayerNames() {
		System.out.println(MESSAGE_INPUT_PLAYER_NAMES);
		return SCANNER.next();
	}

	public static String inputExpectedResults() {
		System.out.println(MESSAGE_INPUT_EXPECTED_RESULTS);
		return SCANNER.next();
	}

	public static int inputLadderHeight() {
		System.out.println(MESSAGE_INPUT_LADDER_HEIGHT);
		return SCANNER.nextInt();
	}

}
