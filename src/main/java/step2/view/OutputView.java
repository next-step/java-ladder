package step2.view;

import step2.model.Line;
import step2.model.Users;

import java.util.List;

public class OutputView {
	private static final String LADDER_HEIGHT = "|";
	private static final String LADDER_STEP = "-----";
	private static final String LADDER_SPACE = "     ";
	private static final String USER_PRINT_SPACE = " ";

	public static void printOutput(Users users, List<Line> list) {
		users.getUsers().stream()
				.map(user -> user.getName() + USER_PRINT_SPACE)
				.forEach(System.out::print);
		System.out.println();
		for (Line line : list) {
			printLadder(line);
			System.out.println();
		}
	}

	private static void printLadder(Line line) {
		line.getLine().stream()
				.map(step -> LADDER_HEIGHT + (step ? LADDER_STEP : LADDER_SPACE))
				.forEach(System.out::print);
		System.out.print(LADDER_HEIGHT);
	}
}
