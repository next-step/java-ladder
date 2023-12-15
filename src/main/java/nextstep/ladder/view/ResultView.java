package nextstep.ladder.view;

import java.util.Map;

import nextstep.ladder.domain.GameResults;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.Row;
import nextstep.ladder.domain.User;

public class ResultView {
	public static String showParticipants(String participants) {
		System.out.println(participants);
		return participants;
	}

	public static String showResults(String inputResults) {
		System.out.println(inputResults);
		return inputResults;
	}

	public static int showHeight(int height) {
		System.out.println(height);
		return height;
	}

	public static void showParticipantsInGame(Participants participants) {
		for (User user : participants.values()) {
			System.out.print(user.value() + "     ");
		}
		System.out.println();
	}

	public static void showLadder(Ladder ladder) {
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

	public static void showResultsInGame(Results results) {
		for (Result result : results.values()) {
			System.out.print(result.value() + "     ");
		}
		System.out.println();
	}

	public static void showGameResults(Participants participants, Results results, GameResults gameResults, String name) {
		System.out.println("실행 결과");
		if (name.equals("all")) {
			showAllUserResults(participants, results, gameResults);
			return;
		}
		for (int i = 0; i < participants.values().size(); i++) {
			if (participants.values().get(i).value().equals(name)) {
				System.out.println(results.values().get(gameResults.values().get(i)).value());
				return;
			}
		}
		throw new IllegalArgumentException("찾는 유저 이름이 없습니다.");
	}

	private static void showAllUserResults(Participants participants, Results results, GameResults gameResults) {
		for (Map.Entry<Integer, Integer> entry : gameResults.values().entrySet()) {
			System.out.println(
				participants.values().get(entry.getKey()).value()
					+ " : "
					+ results.values().get(entry.getValue()).value()
			);
		}
	}
}
