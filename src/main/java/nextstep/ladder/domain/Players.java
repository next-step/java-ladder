package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Players {
    public static final String DELIMITER = ",";
    private static final int PLAYERS_MIN_COUNT = 2;
    private List<Name> players;

    public Players(String players) {
        this(toList(players));
    }

    private static List<Name> toList(String players) {
        return Arrays.stream(players.split(DELIMITER))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public Players(List<Name> players) {
        if (players.size() < PLAYERS_MIN_COUNT) {
            throw new IllegalArgumentException("참가자 수" + players.size() + " 게임을 진행하려면 최소 " + PLAYERS_MIN_COUNT + "명 이상 필요합니다.");
        }
        this.players = players;
    }

    public int size() {
        return players.size();
    }

    public Stream<Name> stream() {
        return players.stream();
    }
}
