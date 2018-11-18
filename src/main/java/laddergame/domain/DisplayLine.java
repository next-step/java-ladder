package laddergame.domain;

import java.util.List;

public class DisplayLine {

	public static final String VERTICAL_CHARACTER = "|";
	public static final String HORIZON_CHARACTER = "-";
	public static final String EMPTY_CHARACTER = " ";

	private List<String> displayCharacters;

	public DisplayLine(List<String> displayCharacters) {
		this.displayCharacters = displayCharacters;
	}

	public String draw() {
		StringBuilder line = new StringBuilder();
		for (String displayCharacter : displayCharacters) {
			line.append(getLineCharacters(displayCharacter)).append(VERTICAL_CHARACTER);
		}
		return line.toString();
	}

	private String getLineCharacters(String displayCharacter) {
		StringBuilder lineCharacters = new StringBuilder();
		for (int count = 0; count < Player.MAX_NAME_LENGTH; count++) {
			lineCharacters.append(displayCharacter);
		}
		return lineCharacters.toString();
	}
}
