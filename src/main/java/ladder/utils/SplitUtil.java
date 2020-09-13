package ladder.utils;

import ladder.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {
    private static final String COMMA = ",";

    public static List<User> splitToList(String name) {
        return Arrays.stream(name.split(COMMA))
                .map(User::of)
                .collect(Collectors.toList());
    }
}
