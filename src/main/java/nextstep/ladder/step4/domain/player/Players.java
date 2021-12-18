package nextstep.ladder.step4.domain.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Players {

    private static final int MINIMUM_SIZE = 2;

    private final List<Name> players;

    private Players(List<Name> players) {
        valid(players);
        this.players = players;
    }

    public static Players of(StringAsSplit stringAsSplit) {
        List<Name> players = Arrays.stream(stringAsSplit.split())
            .map(Name::new)
            .collect(Collectors.toCollection(ArrayList::new));

        return new Players(players);
    }

    public Name get(int index) {
        return players.get(index);
    }

    public int size() {
        return players.size();
    }

    public int nameIndex(String name) {
        return players.indexOf(new Name(name));
    }

    public List<Name> players() {
        return Collections.unmodifiableList(players);
    }

    private void valid(List<Name> players) {
        if (players.isEmpty() || players.size() < MINIMUM_SIZE) {
            throw new IllegalArgumentException(String.format("게임을 하기 위해서는 최소 %d 명이 필요합니다.", MINIMUM_SIZE));
        }
    }

}
