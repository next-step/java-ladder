package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Players {

    private final List<Player> players;

    private Players(List<Player> players) {
        validate(players);
        this.players = players;
    }

    public static Players newInstance(List<Player> players) {
        return new Players(players);
    }

    private void validate(List<Player> players) {
        if (players == null) {
            throw new IllegalArgumentException("참여자들이 존재하지 않습니다.");
        }

        if (players.size() < 2) {
            throw new IllegalArgumentException("참여자 인원은 최소 2명 이상이어야 합니다.");
        }

        if (players.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("존재하지 않는 참여자가 포함되어 있습니다.");
        }
    }

    public List<Player> toList() {
        return Collections.unmodifiableList(this.players);
    }

    public int getCount() {
        return this.players.size();
    }
}
