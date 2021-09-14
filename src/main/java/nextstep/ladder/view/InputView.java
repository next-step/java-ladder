package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
	private static final String INPUT_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
	private static final String INPUT_LADDER_HEIGHT = "최대 사다리의 높이는 몇 개 인가요?";
	private static final Scanner SCANNER = new Scanner(System.in);

	public String inputNames() {
		System.out.println(INPUT_NAMES);
		return SCANNER.nextLine();
	}

	public int inputLadderHeight() {
		System.out.println(INPUT_LADDER_HEIGHT);
		return SCANNER.nextInt();
	}
}