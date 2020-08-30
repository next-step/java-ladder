package nextstep.ladder.utils;

public class StringUtils {

    private static final String INPUT_NAME_DELIMITER = ", |,";

    private String input;

    public StringUtils(String input) {
        this.input = input;
    }

    public String[] split() {
        return input.split(INPUT_NAME_DELIMITER);
    }

}
