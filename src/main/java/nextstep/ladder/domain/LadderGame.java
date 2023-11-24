package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.domain.wrapper.Players;

import java.util.Objects;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(GameInfo gameInfo) {
        this.players = gameInfo.players();
        this.ladder = gameInfo.ladder();
    }

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public String playersName() {
        return players.names();
    }

    public String ladder() {
        return ladder.toString();
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
