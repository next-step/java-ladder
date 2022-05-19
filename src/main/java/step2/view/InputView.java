package step2.view;

import static java.lang.System.*;

import java.util.List;
import java.util.Scanner;

public class InputView {

	private static final String START = "[START]";
	private static final String DELIMITER = ",";

	private final Scanner scanner;

	public InputView() {
		show(START);
		this.scanner = new Scanner(System.in);
	}

	public List<String> askPlayers() {
		show("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return List.of(this.scanner.nextLine().split(DELIMITER));
	}

	public int askHeight() {
		show("최대 사다리 높이는 몇 개인가요?");
		return Integer.parseInt(this.scanner.nextLine());
	}

	private void show(String output) {
		out.println(output);
	}

	public void close() {
		this.scanner.close();
	}
}
