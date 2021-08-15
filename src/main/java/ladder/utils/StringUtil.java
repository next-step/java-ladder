package ladder.utils;

public class StringUtil {

	private StringUtil() {
		throw new IllegalStateException();
	}

	public static boolean isBlank(String text) {
		return text == null || text.trim().isEmpty();
	}

	public static String rightPad(String text, int length) {
		return rightPad(text, length, " ");
	}

	public static String rightPad(String text, int length, String padString) {
		StringBuilder padText = new StringBuilder(text);

		for (int i = 0; i < length - text.length(); i++) {
			padText.append(padString);
		}

		return padText.toString();
	}
}
