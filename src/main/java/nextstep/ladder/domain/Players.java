package nextstep.ladder.domain;

import nextstep.ladder.domain.exceptions.PlayerNamesEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNamesMaxLengthException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private static final String NAME_SEPARATOR = ",";

    private List<Player> values;

    private Players(List<Player> values) {
        this.values = new ArrayList<>(values);
    }

    public static Players create(String inputValue) {
        validate(inputValue);
        List<Player> playerList = parseToPlayerList(parseToNames(inputValue));
        return new Players(playerList);
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

    public HorizontalLocation getLocationOfIndex(int index) {
        return values.get(index).getHorizontalLocation();
    }

    private static List<Player> parseToPlayerList(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(num -> new Player(names.get(num), new HorizontalLocation(num, names.size())))
                .collect(Collectors.toList());
    }

    private static List<String> parseToNames(String inputValue) {
        return Arrays.stream(inputValue.split(NAME_SEPARATOR))
                .map(String::trim)
                .collect(Collectors.toList());
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
        Players that = (Players) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
