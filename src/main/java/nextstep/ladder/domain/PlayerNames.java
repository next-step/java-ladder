package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNamesEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNamesMaxLengthException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerNames {
    private static final String NAME_SEPARATOR = ",";

    private List<Player> values;

    private PlayerNames(List<Player> values) {
        this.values = new ArrayList<>(values);
    }

    public static PlayerNames create(String inputValue) {
        validate(inputValue);
        // TODO: location 추가에 따라 맞는 로직으로 객체 생성하도록 구현 필요
        List<Player> names = Arrays.stream(inputValue.split(NAME_SEPARATOR))
                .map(String::trim)
                .map(name -> new Player(name, 0))
                .collect(Collectors.toList());
        return new PlayerNames(names);
    }

    public int size() {
        return this.values.size();
    }

    public List<String> getPlayerNameValues() {
        return this.values.stream()
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public int getMaxNameLength() {
        return this.values.stream()
                .mapToInt(Player::length)
                .max()
                .orElseThrow(() -> new PlayerNamesMaxLengthException("Can't find max length of PlayerNames"));
    }

    private static void validate(String inputValue) {
        validateNull(inputValue);
        validateEmpty(inputValue);
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue.trim().isEmpty()) {
            throw new PlayerNamesEmptyException("Can't create PlayerNames from empty value");
        }
    }

    private static void validateNull(String inputValue) {
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
