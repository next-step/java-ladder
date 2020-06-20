package study2.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import study2.domain.Ladder;
import study2.domain.Line;
import study2.domain.Players;

public class ResultView {

	private static final String EXECUTEMESSAGE = "실행결과";
	private static final String COLUMN = "     |";
	private static final String ROW = "-----|";
	private static final String NAMES_FORMAT = "%6s";

	public ResultView(Players players, Ladder ladder) {

		System.out.println(EXECUTEMESSAGE);
		viewPlayerList(players);
		viewRowAndColumn(ladder);
	}

	private void viewPlayerList(Players players) {
		players.getPlayers().forEach(
				player -> System.out.print(
						String.format(NAMES_FORMAT, player.getPlayerName())));
		System.out.println();
	}

	private void viewRowAndColumn(Ladder ladder) {

		ladder.getLadder().forEach(line -> choiceRowOrColum(line));
		System.out.println();
	}

	private void choiceRowOrColum(Line line) {
		line.getLine().stream().forEach(s -> printBarAndColumn(s));
		System.out.println();
	}

	private void printBarAndColumn(Boolean point) {
		if (point) {
			System.out.print(ROW);
		}
		if (!point) {
			System.out.print(COLUMN);
		}
	}
}
