package nextstep.ladder.view;

import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Players;

public class ResultView {

	private static final String SPACING_WORDS = " ";
	private static final int INITIAL_INDEX = 0;
	private static final int LENGTH_OF_NAME_FOR_OUTPUT = 6;

	private ResultView() {
	}

	public static void printPlayerNames(Players players) {
		players.values()
			.stream()
			.map(Player::getName)
			.forEach(playerName -> System.out.print(processPlayerName(playerName)));
	}

	public static String processPlayerName(String playerName) {
		StringBuilder builder = new StringBuilder();
		for (int i = INITIAL_INDEX; i < LENGTH_OF_NAME_FOR_OUTPUT - playerName.length(); i++) {
			builder.append(SPACING_WORDS);
		}
		builder.append(playerName);
		return builder.toString();
	}
}
