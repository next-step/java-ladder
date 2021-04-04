package ladder.view;

import java.util.Scanner;

public class InputView {
	Scanner scanner = new Scanner(System.in);

	public String getString(String text) {
		String input = getInput(text);
		return input;
	}
	public Integer getInt(String text) {
		String input = getInput(text);
		return Integer.valueOf(input);
	}

	private String getInput(String text) {
		System.out.println(text);
		return scanner.nextLine();
	}
}
