package nextstep.ladder.domain;

import nextstep.ladder.domain.player.Name;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.dto.LadderDto;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private final Players players;
    private final LadderBoard ladderBoard;

    public LadderGame(Players players, LadderBoard ladderBoard) {
        this.players = players;
        this.ladderBoard = ladderBoard;
    }

    public Reward getReward(Name playerName) {
        return ladderBoard.getReward(players.searchBy(playerName));
    }

    public List<Reward> getRewards(List<Name> playerNameList) {
        return playerNameList.stream().map(this::getReward).collect(Collectors.toList());
    }

    public LadderDto getLadder() {
        return ladderBoard.getLadder();
    }

}
