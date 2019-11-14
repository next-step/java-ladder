package ladder.view;

import java.util.Scanner;

public class InputView {

	private static Scanner scanner = new Scanner(System.in);

	private InputView() {

	}

	public static String[] receivePeopleName() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return StringParser.parse(scanner.nextLine());
	}

	public static String[] receiveLadderResult() {
		System.out.println();
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		return StringParser.parse(scanner.nextLine());
	}

	public static int receiveLadderHeight() {
		System.out.println();
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		int lineHeight = scanner.nextInt();
		cleanScannerBuffer();
		return lineHeight;
	}

	public static String receivePersonNameToShowResult() {
		System.out.println();
		System.out.println("결과를 보고 싶은 사람은?");
		return scanner.nextLine();
	}

	private static void cleanScannerBuffer() {
		scanner.nextLine();
	}

}
