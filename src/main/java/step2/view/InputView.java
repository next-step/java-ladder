package step2.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
	private static Scanner scanner = new Scanner(System.in);

	public static String inputUserName() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return scanner.nextLine();
	}

	public static int inputLadderHeight() {
		int ladderHeight;
		System.out.println("최대 사다리 높이는 몇 개인가요?");

		try {
			ladderHeight = scanner.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("잘못된 입력입니다. 정수를 입력해주세요");
			scanner = new Scanner(System.in);
			ladderHeight = scanner.nextInt();
		}

		return ladderHeight;
	}
}
