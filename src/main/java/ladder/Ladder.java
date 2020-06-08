package ladder;

import java.util.Objects;

public class Ladder {

    private final Players players;

    public Ladder(Players players, LadderHeight ladderHeight) {
        Objects.requireNonNull(players, "players는 null일 수 없습니다.");
        Objects.requireNonNull(ladderHeight, "ladderHeight은 null일 수 없습니다.");

        this.players = players;
    }

}
