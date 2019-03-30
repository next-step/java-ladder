package console;

import java.util.List;

public class SpacingLetterHelper {
    public static int makeLengthFrom(List<String> strings) {
        return strings.stream()
            .mapToInt(string -> string.length())
            .max()
            .getAsInt() + 2;
    }
}
