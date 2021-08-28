package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Players {

    private final List<Player> players;

    private Players(String[] playerNames) {
        Objects.requireNonNull(playerNames, "플레이어 이름목록은 필수입력입니다.");

        this.players = Arrays.stream(playerNames)
            .map(Player::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public static Players from(String[] playerNames) {
        return new Players(playerNames);
    }

    public int count() {
        return players.size();
    }
}
