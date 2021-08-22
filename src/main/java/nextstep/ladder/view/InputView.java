package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {

	private static final Scanner SCANNER = new Scanner(System.in);
	private static final String MESSAGE_INPUT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";

	private InputView() {
	}

	public static String inputPlayerNames() {
		System.out.println(MESSAGE_INPUT_PLAYER_NAMES);
		return SCANNER.next();
	}

}
