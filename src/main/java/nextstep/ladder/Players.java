package nextstep.ladder;

import nextstep.ladder.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players {
    private final static int MIN_PLAYERS = 2;
    private List<Player> players;

    private Players(String[] values) {
        validation(values);
        this.players = createPlayers(values);
    }

    private void validation(String[] values) {
        if (values.length < MIN_PLAYERS) {
            throw new IllegalArgumentException("최소 참가자 인원은 2명 이상이어야 합니다.");
        }
    }

    private List<Player> createPlayers(String[] values) {
        return IntStream.range(0, values.length)
                .mapToObj(position -> Player.of(values[position], position))
                .collect(Collectors.toList());
    }

    public static Players of(String value) {
        return new Players(StringUtils.stringToArray(value));
    }

}
