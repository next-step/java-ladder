package ladder.view;

import ladder.domain.result.Results;
import ladder.domain.user.Users;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
	private static final String PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	public static final String RESULT_NAMES_MESSAGE = "실행결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
	public static final String RESULT_NAME_MESSAGE = "결과를 보고 싶은 사람은?";

	public static Users getPlayerNames() {
		print(PLAYER_NAMES_MESSAGE);
		return Users.createUsers(scanner.next());
	}

	public static Results getResults(Users users) {
		print(RESULT_NAMES_MESSAGE);
		return Results.createResults(scanner.next(), users.getCountOfPerson());
	}

	public static int getLadderHeight() {
		print(LADDER_HEIGHT_MESSAGE);
		return scanner.nextInt();
	}

	public static String getMatchUser() {
		print(RESULT_NAME_MESSAGE);
		return scanner.next();
	}

	private static void print(String message) {
		System.out.println(message);
	}
}
