package ladder.view;

import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.PointEnum;
import ladder.domain.user.Users;

import java.util.List;

public class OutputView {
	public static void printResult(Users users, int ladderHeight) {
		System.out.println("실행결과");
		System.out.println("");

		System.out.println(users.toString());
		Ladder.createLadder(Height.createHeight(ladderHeight), users.getCountOfPerson()).getLines()
				.forEach(line -> toPrint(line.getPoints()));
	}

	private static void toPrint(List<PointEnum> points) {
		StringBuilder sb = new StringBuilder();
		for (PointEnum point : points) {
			sb.append("|");
			appendPoint(point, sb);
		}
		sb.append("|");
		System.out.println(sb.toString());
	}
	private static void appendPoint(final PointEnum point, final StringBuilder sb) {
		if (PointEnum.isTrue(point)) {
			sb.append("-----");
			return;
		}
		sb.append("     ");
	}
}
