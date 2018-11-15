package game.ladder.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class Spliter {

    public static final Pattern SPLIT_PATTERN = Pattern.compile("\\s*,\\s*");

    public static List<String> split(String str) {
        return Arrays.asList(SPLIT_PATTERN.split(str));
    }

}
