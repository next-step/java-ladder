package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNamesEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNamesMaxLengthException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerNames {
    private List<PlayerName> values;

    private PlayerNames(List<PlayerName> values) {
        this.values = new ArrayList<>(values);
    }

    public static PlayerNames create(String inputValue) {
        validation(inputValue);
        List<PlayerName> values = Arrays.stream(inputValue.split(","))
                .map(String::trim)
                .map(PlayerName::new)
                .collect(Collectors.toList());
        return new PlayerNames(values);
    }

    public int size() {
        return this.values.size();
    }

    public int getMaxNameLength() {
        return this.values.stream()
                .mapToInt(PlayerName::length)
                .max()
                .orElseThrow(() -> new PlayerNamesMaxLengthException("Can't find max length of PlayerNames"));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerNames that = (PlayerNames) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
