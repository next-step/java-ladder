package common;

import java.util.Arrays;

public class SpacingLetterMaker {
    public static int makeLengthFrom(String... strings) {
        return Arrays.stream(strings)
            .mapToInt(string -> string.length())
            .max()
            .getAsInt();
    }
}
