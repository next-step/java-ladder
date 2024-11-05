package ladder.domain.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitUtil {

    public static final String DELIMITER = ",";

    public static List<String> split(String text) {
        return Arrays.stream(text.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
