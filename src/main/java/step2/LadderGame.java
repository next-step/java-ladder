package step2;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGame {

    public static final String DELIMITER = ",";

    public static LadderPlayers join(String input) {
        List<String> names = toList(input);
        return new LadderPlayers(names);
    }

    private static List<String> toList(String input) {
        isValid(input);
        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(LadderGame::isNotEmpty)
                .collect(Collectors.toList());
    }

    private static void isValid(String input) {
        if (Objects.isNull(input) || input.equals("")) {
            throw new NoSuchElementException();
        }
    }

    private static boolean isNotEmpty(String name) {
        return !name.equals("");
    }

    public static Ladder makeLadder(LadderPlayers players, int height) {
        return null;
    }
}
