package step2.domain.ladder;

import step2.domain.ladder.dto.LadderBuildDTO;
import step2.strategy.MakeLineStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;

public class LadderGame {

    public static final String DELIMITER = ",";
    public static final String SPACE = "";

    private LadderGame() {}

    public static LadderPlayers join(String input) {
        isValid(input);

        return Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .filter(LadderGame::isNotEmpty)
                .collect(collectingAndThen(Collectors.toList(), LadderPlayers::of));
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
        return Ladder.of(buildDTO, strategy);
    }
}
