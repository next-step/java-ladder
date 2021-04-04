package nextstep.ladder.domain;

import nextstep.ladder.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    public final static String NAME_SEPARATOR = ",";
    private List<Player> players;

    public Players(String value) {
        validation(value);
        players = generatePlayers(value.split(NAME_SEPARATOR));
    }

    public void validation(String value) {
        if (StringUtils.isEmpty(value)) {
            throw new IllegalArgumentException("참가자의 이름은 비어있는 값 일 수 없습니다.");
        }
    }

    private List<Player> generatePlayers(String[] values) {
        return Arrays.stream(values)
                .map(Player::new)
                .collect(Collectors.toList());
    }

    public int countOfPlayers() {
        return players.size();
    }

    public static Players from(String value) {
        return new Players(value);
    }

    public String names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.joining(" "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    @Override
    public String toString() {
        return "Players{" +
                "players=" + players +
                '}';
    }
}
