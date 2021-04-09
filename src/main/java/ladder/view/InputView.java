package ladder.view;

import java.util.Scanner;

public class InputView {
	Scanner scanner = new Scanner(System.in);

	public String getString(String text) {
		return getInput(text);
	}

	public Integer getInt(String text) {
		return Integer.valueOf(getInput(text));
	}

	private String getInput(String text) {
		System.out.println(text);
		return scanner.nextLine();
	}
}
