package nextstep.ladder.domain;

import nextstep.ladder.controller.dto.GameInfo;
import nextstep.ladder.domain.wrapper.Players;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public LadderGame(GameInfo gameInfo) {
        this(gameInfo.players(), gameInfo.ladder());
    }

    public String playersName() {
        return players.names();
    }

    public String ladder() {
        return ladder.toString();
    }
}
