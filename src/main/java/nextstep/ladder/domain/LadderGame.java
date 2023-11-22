package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.domain.wrapper.Players;

import java.util.Objects;

public class LadderGame {

    private Players players;
    private Ladder ladder;

    public LadderGame(GameInfo gameInfo) {
        this.players = gameInfo.players();
        this.ladder = gameInfo.ladder();
    }

    public LadderGame(Ladder ladder, Players players) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGame that = (LadderGame) o;
        return Objects.equals(players, that.players) && Objects.equals(ladder, that.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players, ladder);
    }
}
