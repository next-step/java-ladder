package laddarGame.util;

public class Parser {

    private static final String DELIMITER = ",";

    public static String[] nameParser(String playerNames) {
        return playerNames.split(DELIMITER);
    }
}
