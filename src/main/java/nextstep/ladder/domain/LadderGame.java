package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final int MIN_PLAYERS_COUNT = 2;
    private final List<Player> players;
    private final Ladder ladder;

    public LadderGame(final List<String> players, final int height) {
        if (players.size() < MIN_PLAYERS_COUNT) {
            throw new IllegalArgumentException("두명 이상의 참여자가 필요합니다.");
        }
        this.players = Collections.unmodifiableList(
                players.stream()
                        .map(Player::new)
                        .collect(Collectors.toList())
        );
        this.ladder = new Ladder(players.size(), height);
    }
}
