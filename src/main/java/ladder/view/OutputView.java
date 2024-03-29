package ladder.view;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.user.Users;

public class OutputView {
	public static void printResult(Users users, int ladderHeight) {
		System.out.println("실행결과");
		System.out.println("");

		System.out.println(users.toString());
		Ladder.createLadder(Height.createHeight(ladderHeight), users.getCountOfPerson()).getLines()
				.forEach(System.out::println);
	}
}
