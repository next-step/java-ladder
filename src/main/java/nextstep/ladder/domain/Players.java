package nextstep.ladder.domain;

import nextstep.ladder.utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    public final static String NAME_SEPARATOR = ",";
    private final List<Player> players;

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
        return IntStream.range(0, values.length)
                .mapToObj(position -> new Player(values[position], position))
                .collect(Collectors.toList());
    }

    public int countOfPlayers() {
        return players.size();
    }

    public static Players from(String value) {
        return new Players(value);
    }

    public List<String> names() {
        return players.stream()
                .map(Player::name)
                .collect(Collectors.toList());
    }

    public Player player(String name) {
        return players.stream()
                .filter(player -> name.equals(player.name()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("참가자 이름을 확인해 주세요."));
    }

    public List<Player> players() {
        return Collections.unmodifiableList(players);
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
