package ladder.view;

import java.util.Map;

import ladder.domain.InputResult;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Player;
import ladder.domain.Players;

public class ResultView {

	public void printResultHead() {
		System.out.println();
		System.out.println("실행결과");
		System.out.println();
	}

	public void printPlayer(Players players) {
		for (Player player : players.getPlayers()) {
			String formatString = String.format("%6s", player.toString());
			System.out.print(formatString);
		}
		System.out.println();
	}

	public void printLadder(Ladder ladder) {
		ladder.getLadder().forEach((line) -> {
			System.out.print(String.format("%5s", ""));
			line.getPoints().forEach(points -> {
				if (points) {
					System.out.print(String.format("%-6s", "|-----"));
				}
				if (!points) {
					System.out.print(String.format("%-6s", "|"));
				}
			});
			System.out.println();
		});
	}

	public void printInputResult(InputResult inputResults) {
		for (String inputResult : inputResults.getInputResults()) {
			String formatString = String.format("%6s", inputResult.toString());
			System.out.print(formatString);
		}
		System.out.println();
		System.out.println();
	}

	public void printFinalResult(LadderResult ladderResult, String inputResultName) {
		System.out.println();
		System.out.println("실행결과");
		if (inputResultName.equals("all")) {
			printAllPlayerResult(ladderResult.getAllResult());
			return;
		}
		printPlayerResult(ladderResult.getResult(inputResultName));
	}

	private void printAllPlayerResult(Map<String, String> allResult) {
		for (String key : allResult.keySet()) {
			System.out.println(key + " : " + allResult.get(key));
		}
	}

	private void printPlayerResult(String result) {
		System.out.println(result);
	}
}
