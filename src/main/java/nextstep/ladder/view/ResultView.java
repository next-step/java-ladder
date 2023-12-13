package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.User;

public class ResultView {
	public static String showParticipants(String participants) {
		System.out.println(participants);
		return participants;
	}

	public static int showHeight(int height) {
		System.out.println(height);
		return height;
	}
	public static void showLadder(int height, Ladder ladder) {
		for (User user : ladder.participants().values()) {
			System.out.print(user.getName() + "     ");
		}
		System.out.println();
		// indent 개선
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < ladder.lines().lines().size()-1; j++) {
				System.out.print("|");
				if (ladder.lines().lines().get(j).points().get(i).isRight()) {
					System.out.print("------");
					continue;
				}
				System.out.print("      ");
			}
			System.out.println();
		}
	}
}
