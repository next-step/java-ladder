package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exceptions.PlayerNamesEmptyException;
import nextstep.ladder.domain.exceptions.PlayerNamesMaxLengthException;
import nextstep.ladder.domain.exceptions.PlayerNotExistException;
import nextstep.ladder.domain.ladder.HorizontalLocation;
import nextstep.ladder.domain.ladder.Ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private List<Player> values;

    public Players(List<Player> values) {
        this.values = new ArrayList<>(values);
    }

    public static Players create(List<String> nameValues) {
        validate(nameValues);
        List<Player> playerList = parseToPlayerList(nameValues);
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

    public Player getPlayerOfLocation(int location) {
        return this.values.stream()
                .filter(player -> player.getPlayerLocationValue() == location)
                .findFirst()
                .orElseThrow(() -> new PlayerNotExistException("No player in that place"));
    }

    private static List<Player> parseToPlayerList(List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(num -> new Player(names.get(num), new HorizontalLocation(num, names.size())))
                .collect(Collectors.toList());
    }

    private static void validate(List<String> nameValues) {
        validateNull(nameValues);
        validateEmpty(nameValues);
    }

    private static void validateEmpty(List<String> nameValues) {
        if (nameValues.size() == 0) {
            throw new PlayerNamesEmptyException("Can't create PlayerNames from empty value");
        }
    }

    private static void validateNull(List<String> nameValues) {
        if (nameValues == null) {
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

    public void playLadderGame(Ladder ladder) {
        this.values.forEach(ladder::playGame);
    }
}
