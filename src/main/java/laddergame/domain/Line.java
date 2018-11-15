package laddergame.domain;

import java.util.List;

public class Line {

	private static final String VERTICAL_CHARACTER = "|";
	private static final String HORIZON_CHARACTER = "-";
	private static final String EMPTY_CHARACTER = " ";

	private List<Boolean> points;

	public Line(int playerCount) {
		this(RandomLineGenerator.generate(playerCount));
	}

	public Line(List<Boolean> points) {
		this.points = points;
	}

	public String draw() {
		StringBuilder line = new StringBuilder();
		for (Boolean point : points) {
			line.append(getLineCharacters(point)).append(VERTICAL_CHARACTER);
		}
		return line.toString();
	}

	private String getLineCharacters(Boolean point) {
		StringBuilder lineCharacters = new StringBuilder();
		String lineCharacter = (point)? HORIZON_CHARACTER : EMPTY_CHARACTER;
		for (int count = 0; count < Player.MAX_NAME_LENGTH; count++) {
			lineCharacters.append(lineCharacter);
		}
		return lineCharacters.toString();
	}
}
