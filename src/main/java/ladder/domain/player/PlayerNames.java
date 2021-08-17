package ladder.domain.player;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import ladder.exception.InvalidPlayerNamesException;

public class PlayerNames {

    public static final String COMMA_DELIMITER_REGEX = "\\s*,\\s*";

    private final List<PlayerName> names;

    private PlayerNames(List<PlayerName> names) {
        validate(names);
        this.names = names;
    }

    public static PlayerNames of(List<PlayerName> names) {
        return new PlayerNames(names);
    }

    public static PlayerNames of(String text) {
        return Arrays.stream(text.split(COMMA_DELIMITER_REGEX))
                .map(PlayerName::of)
                .collect(Collectors.collectingAndThen(Collectors.toList(), PlayerNames::new));
    }

    public int countOfPeople() {
        return names.size();
    }

    public List<String> toStrings() {
        return names.stream()
                .map(PlayerName::value)
                .collect(Collectors.toList());
    }

    private static void validate(List<PlayerName> names) {
        if (names == null || names.isEmpty()) {
            throw new InvalidPlayerNamesException();
        }
    }

    public int maxNameLength() {
        return names.stream()
                .mapToInt(PlayerName::length)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
