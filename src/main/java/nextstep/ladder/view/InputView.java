package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
	private static final String DELIMITER = ",";
	Scanner scanner = new Scanner(System.in);

	public String[] inputNames() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return split(scanner.nextLine());
	}

	public String[] inputResult() {
		System.out.println("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		return split(scanner.nextLine());
	}

	public String inputName() {
		System.out.println("\n결과를 보고 싶은 사람은?");
		return scanner.next();
	}

	public int inputLadderHeight(){
		System.out.println("\n최대 사다리 높이는 몇 개인가요?");
		return scanner.nextInt();
	}

	public String[] split(final String input) {
		return input.split(DELIMITER);
	}
}
