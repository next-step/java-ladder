package ladder.utils;

import ladder.domain.player.Name;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NameSplitter {

    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\s*,\\s*");

    public static List<Name> split(String names) {
        return Arrays.stream(SPLIT_PATTERN.split(names))
                .map(Name::valueOf)
                .collect(Collectors.toList());
    }
}
