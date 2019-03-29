package common;

import java.util.List;

public class SpacingLetterMaker {
    public static int makeLengthFrom(List<String> strings) {
        return strings.stream()
            .mapToInt(string -> string.length())
            .max()
            .getAsInt() + 4;
    }
}
