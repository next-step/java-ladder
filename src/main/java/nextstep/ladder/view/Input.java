package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;

public class Input {
	private final static Scanner SCANNER = new Scanner(System.in);
	private final static String SEPARATOR = ",";

	private Input() {
	}

	public static String[] inputPlayers() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		String players = nextLine();
		System.out.println();
		return players.split(SEPARATOR);
	}

	public static int inputLadderHeights() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		String height = nextLine();
		System.out.println();
		return Integer.parseInt(height);
	}

	private static String nextLine() {
		return SCANNER.nextLine();
	}

}
