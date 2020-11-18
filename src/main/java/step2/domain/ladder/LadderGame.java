package step2.domain.ladder;

import step2.domain.ladder.dto.LadderBuildDTO;
import step2.strategy.MakeLineStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderGame {

    public static final String DELIMITER = ",";
    public static final String SPACE = "";

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
        if (Objects.isNull(input) || input.equals(SPACE)) {
            throw new NoSuchElementException();
        }
    }

    private static boolean isNotEmpty(String name) {
        return !name.equals(SPACE);
    }

    public static Ladder makeLadder(LadderBuildDTO buildDTO, MakeLineStrategy strategy) {
        return new Ladder(buildDTO, strategy);
    }
}
