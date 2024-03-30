package ladder.view;

import ladder.domain.user.Users;

import java.util.Scanner;

public class InputView {
	private static final Scanner scanner = new Scanner(System.in);
	private static final String LADDER_HEIGHT_MESSAGE = "최대 사다리 높이는 몇 개인가요?";
	private static final String PLAYER_NAMES_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

	public static Users getPlayerNames() {
		print(PLAYER_NAMES_MESSAGE);
		return Users.createUsers(scanner.nextLine());
	}

	public static int getLadderHeight() {
		print(LADDER_HEIGHT_MESSAGE);
		return scanner.nextInt();
	}

	private static void print(String message) {
		System.out.println(message);
	}
}
