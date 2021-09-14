package utils;

import domain.Ladder;
import domain.Line;
import domain.Users;

import java.util.List;

public class Result {

	private static final Integer INIT_NUMBER = 0;
	private static final String SPACE = " ";

	public void viewUsers(Users users) {
		for (int number = INIT_NUMBER ; number < users.count() ; ++number) {
			System.out.print(users.appear(number).toString() + SPACE);
		}
		System.out.println();
	}

	public void viewLadder(List<Line> lines) {
		for (int number = INIT_NUMBER ; number < lines.size() ; ++number) {
			System.out.println(viewLine(lines.get(number)));
		}
	}

	private String viewLine(Line line) {
		String result = Ladder.VERTICAL.view();
		for (int number = INIT_NUMBER ; number < line.size() ; ++number) {
			result += line.verify(number) ? Ladder.IS_WIDTH.view() : Ladder.NOT_IS_WIDTH.view();
			result += Ladder.VERTICAL.view();
		}
		return result;
	}

}
