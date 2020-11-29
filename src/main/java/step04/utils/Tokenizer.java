package step04.utils;

import java.util.Arrays;
import java.util.List;

public class Tokenizer {
    private Tokenizer() {}

    private static final String COMMA = ",";

    public static List<String> tokenizeWithComma(String string) {
        return Arrays.asList(string.split(COMMA));
    }
}
