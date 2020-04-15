package ladder.game.domain;

import ladder.ladder.domain.Ladder;
import ladder.player.domain.Player;
import ladder.prize.domain.Prize;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final LadderGameInfo ladderGameInfo;

    private LadderGame(Ladder ladder, LadderGameInfo ladderGameInfo) {
        this.ladder = ladder;
        this.ladderGameInfo = ladderGameInfo;
    }

    public static LadderGame init(LadderGameInfo ladderGameInfo, int height) {
        Ladder ladder = Ladder.of(height, ladderGameInfo.getPlayers());
        return new LadderGame(ladder, ladderGameInfo);
    }

    static LadderGame of(Ladder ladder, LadderGameInfo ladderGameInfo) {
        return new LadderGame(ladder, ladderGameInfo);
    }

    public LadderGameResults play() {
        Map<Player, Prize> ladderGameResults = new HashMap<>();
        int countOfPlayer = ladderGameInfo.getCountOfPlayer();
        for (int i = 0; i < countOfPlayer; i++) {
            int resultIndex = ladder.move(i);
            ladderGameResults.put(ladderGameInfo.getPlayer(i), ladderGameInfo.getResult(resultIndex));
        }
        return LadderGameResults.of(ladderGameResults);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameInfo getLadderGameInfo() {
        return ladderGameInfo;
    }
}
