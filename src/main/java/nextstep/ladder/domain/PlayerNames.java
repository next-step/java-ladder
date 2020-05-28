package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNamesEmptyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNames {
    private List<PlayerName> values;

    private PlayerNames(List<PlayerName> values) {
        this.values = new ArrayList<>(values);
    }

    public static PlayerNames create(String inputValue) {
        validation(inputValue);
        List<PlayerName> values = Arrays.stream(inputValue.trim().split(","))
                .map(PlayerName::new)
                .collect(Collectors.toList());
        return new PlayerNames(values);
    }

    public int size() {
        return this.values.size();
    }

    private static void validation(String inputValue) {
        nullValidation(inputValue);
        emptyValidation(inputValue);
    }

    private static void emptyValidation(String inputValue) {
        if (inputValue.trim().isEmpty()) {
            throw new PlayerNamesEmptyException("Can't create PlayerNames from empty value");
        }
    }

    private static void nullValidation(String inputValue) {
        if (inputValue == null) {
            throw new PlayerNamesEmptyException("Can't create PlayerNames from null source");
        }
    }
}
