package nextstep.ladder.view;

import java.util.Scanner;

public class InputView {
	private static final String DELIMITER = ",";
	Scanner scanner = new Scanner(System.in);

	public String[] inputNames() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return scanner.nextLine().split(DELIMITER);
	}

	public int inputLadderHeight(){
		System.out.println("\n최대 사다리 높이는 몇 개인가요?");
		return scanner.nextInt();
	}
}
