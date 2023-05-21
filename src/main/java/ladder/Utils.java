package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final int MAX_NAME_SIZE = 5;

    public static List<String> fillOrRightAlign(List<String> playersNames) {
        return playersNames.stream()
                .map(name -> name.length() < MAX_NAME_SIZE ? String.format("%5s", name) : name)
                .collect(Collectors.toList());
    }
}
