package step3.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
	private static final String USER_NAME_PHRASES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String GAME_RESULT_PHRASES = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
	private static final String LADDER_HEIGHT_PHRASES = "최대 사다리 높이는 몇 개인가요?";
	private static final Pattern DELIMITER = Pattern.compile(",");

	private static final Scanner scanner = new Scanner(System.in);

	private InputView() {}

	public static String[] inputUsersName() {
		System.out.println(USER_NAME_PHRASES);
		return scanner.nextLine().split(DELIMITER.pattern());
	}

	public static String[] inputGameResult() {
		System.out.println(GAME_RESULT_PHRASES);
		return scanner.nextLine().split(DELIMITER.pattern());
	}

	public static int inputLadderHeight() {
		System.out.println(LADDER_HEIGHT_PHRASES);
		return Integer.parseInt(scanner.nextLine());
	}
}
