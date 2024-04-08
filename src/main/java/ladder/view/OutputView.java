package ladder.view;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.PointEnum;
import ladder.domain.ladder.RandomPointLines;
import ladder.domain.result.Result;
import ladder.domain.result.Results;
import ladder.domain.user.User;
import ladder.domain.user.Users;

import java.util.List;

public class OutputView {
	public static Ladder printLadderResult(Users users, int ladderHeight, Results results) {
		System.out.println("사다리 결과");
		System.out.println("");

		Ladder ladder = Ladder.createLadder(ladderHeight, users, results, new RandomPointLines());

		ladder.getUsers().stream()
				.map(User::getNameWithSpace)
				.forEach(System.out::print);
		System.out.println("");

		ladder.getLines().forEach(line -> toPrint(line.getPoints()));

		ladder.getResults().stream()
				.map(Result::getValueWithSpace)
				.forEach(System.out::print);
		System.out.println("");

		return ladder;
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

	public static void printResult(Ladder ladder, String matchUser) {
		System.out.println("실행 결과");
		System.out.println(ladder.getMatchResult(matchUser));
	}
}
