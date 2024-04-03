package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private final static String NAME_DELIMITER = ",";
	public static List<String> InputNames() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		String names = scanner.nextLine();
		return getStringNames(names);
	}

	private static List<String> getStringNames(String names) {
		String [] splitNames = names.split(NAME_DELIMITER);
		return Arrays.asList(splitNames);
	}

	public static int InputLadderHeight() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return scanner.nextInt();
	}

}
