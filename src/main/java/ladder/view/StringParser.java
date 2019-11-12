package ladder.view;

class StringParser {

	private static final String DELIMITER = ",";

	private StringParser() {

	}

	static String[] parse(String inputString) {
		return inputString.split(DELIMITER);
	}

}
