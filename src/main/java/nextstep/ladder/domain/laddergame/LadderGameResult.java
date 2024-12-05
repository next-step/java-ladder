package nextstep.ladder.domain.laddergame;

import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.position.PlayerPositions;
import nextstep.ladder.domain.laddergame.position.Positions;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.List;
import java.util.stream.Collectors;

public class LadderGameResult {

    private final PlayerPositions playerPositions;
    private final LadderResult ladderResult;

    public LadderGameResult(List<Player> players, List<Positions> positions, LadderResult ladderResult) {
        this(new PlayerPositions(new Players(players), positions), ladderResult);
    }

    public LadderGameResult(PlayerPositions playerPositions, LadderResult ladderResult) {
        this.playerPositions = playerPositions;
        this.ladderResult = ladderResult;
    }

    public String getResult(String playerName) {
        return ladderResult.getResultByIndex(playerPositions.getLastPosition(playerName));
    }

    public List<String> getResultAll() {
        return playerPositions.getPlayers().stream()
                              .map(player -> player.getName() + " : " + getResult(player.getName()))
                              .collect(Collectors.toList());
    }

}
