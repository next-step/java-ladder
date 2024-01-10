package ladder.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
	private static final Scanner SCANNER = new Scanner(System.in);

	public static List<String> inputNames() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return new ArrayList<>(List.of(split(SCANNER.nextLine())));
	}

	public static List<String> inputGifts() {
		System.out.printf("%n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)%n");
		return new ArrayList<>(List.of(split(SCANNER.nextLine())));
	}

	public static int inputHeight() {
		System.out.printf("%n최대 사다리 높이는 몇 개인가요?%n");

		return checkNumber(SCANNER.nextLine());
	}

	private static int checkNumber(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException error) {
			throw new NumberFormatException("숫자를 입력해주세요");
		}
	}

	private static String[] split(String string) {
		return string.replaceAll(" ", "").split(",");
	}
}
