package nextstep.ladder.domain.laddergame;

import nextstep.ladder.domain.ladder.LadderResult;
import nextstep.ladder.domain.laddergame.position.Positions;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.List;

public class LadderGameResult {
    private final Players players;
    private final List<Positions> positions;
    private final LadderResult ladderResult;

    public LadderGameResult(List<Player> players, List<Positions> positions, LadderResult ladderResult) {
        this.players = new Players(players);
        this.positions = positions;
        this.ladderResult = ladderResult;
    }

    // 개인별 결과 얻기
    public String getResult(String playerName) {
        Positions playerPositions = positions.get(players.findIndexByName(playerName));
        int lastPosition = playerPositions.getLastPosition();

        return ladderResult.getResultByIndex(lastPosition);
    }

    // 모든 결과 얻기

}
