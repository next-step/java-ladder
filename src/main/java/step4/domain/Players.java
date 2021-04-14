package step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import step4.exception.DuplicateNameException;
import step4.util.StringSpliter;

public class Players {
    private final List<Player> players = new ArrayList<>();

    private Players(String[] names) {
        IntStream.range(0, names.length)
            .forEach(i -> {
                validate(names[i]);
                players.add(new Player(i, names[i]));
            });
    }

    public static Players of(String names) {
        String[] splitNames = StringSpliter.split(names);
        return new Players(splitNames);
    }

    public static Players of(String[] names) {
        return new Players(names);
    }

    private void validate(String name) {
        boolean isExists = players.stream()
            .filter(player -> player.isNameEqual(new PlayerName(name)))
            .findFirst()
            .isPresent();

        if (isExists) {
            throw new DuplicateNameException("동일한 이름을 가진 참여자가 존재합니다.");
        }
    }

    public int playerCount() {
        return players.size();
    }

    public List<Player> players() {
        return this.players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Players players1 = (Players)o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }
}
