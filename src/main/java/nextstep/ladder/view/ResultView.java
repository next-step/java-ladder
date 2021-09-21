package nextstep.ladder.view;

import java.util.List;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;

public class ResultView {
	private static final String START_LINE = "      |";
	private static final String EXIST_LINE = "-----|";
	private static final String EMPTY_LINE = "     |";

	public void viewPlayers(Players players) {
		StringBuilder view = new StringBuilder();
		List<Player> playerList = players.getPlayers();
		playerList.forEach(player -> {
			String name = String.format("%6s", player.toString());
			view.append(name);
		});
		System.out.println(view);
	}

	public void viewLadder(Ladder ladder) {
		StringBuilder view = new StringBuilder();
		List<Line> lines = ladder.getLines();
		lines.forEach(line -> view.append(drawLine(line.getPoints()))
			.append("\n"));
		System.out.println(view);
	}

	private String drawLine(List<Boolean> points) {
		StringBuilder view = new StringBuilder();
		view.append(START_LINE);
		points.forEach(point -> {
			if (point) {
				view.append(EXIST_LINE);
				return;
			}
			view.append(EMPTY_LINE);
		});
		return view.toString();
	}
}
