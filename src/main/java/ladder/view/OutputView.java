package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.user.Users;

public class OutputView {
	public static void printResult(Users users, int ladderHeight) {
		System.out.println("실행결과");
		System.out.println("");

		System.out.println(users.toString());
		Ladder.createLadder(ladderHeight, users.getCountOfPerson()).printLadder();
	}
}
