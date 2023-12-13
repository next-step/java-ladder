package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Row;
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

	public static void showLadder(Ladder ladder) {
		for (User user : ladder.participants().values()) {
			System.out.print(user.value() + "     ");
		}
		System.out.println();

		for (Row row : ladder.rows().values()) {
			showRows(row);
		}
	}

	private static void showRows(Row row) {
		System.out.print("|");
		for (int idx = 0; idx < row.values().size() - 1; idx++) {
			showHorizonBar(row.values().get(idx));
		}
		System.out.println();
	}

	private static void showHorizonBar(Point point) {
		if (point.isRight()) {
			System.out.print("------|");
			return;
		}
		System.out.print("      |");
	}
}
