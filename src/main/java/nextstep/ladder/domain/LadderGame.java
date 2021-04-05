package nextstep.ladder.domain;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.dto.LadderDto;
import nextstep.ladder.dto.PlayerDto;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public List<PlayerDto> getPlayers() {
        return players.export();
    }

    public LadderDto getLadder() {
        return ladder.export();
    }

}
