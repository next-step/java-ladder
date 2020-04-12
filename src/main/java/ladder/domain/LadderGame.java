package ladder.domain;

import ladder.dto.GameInfo;
import ladder.dto.GameResult;
import ladder.dto.GameResults;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int RULE_LADDER_HEIGHT_MIN_COUNT = 1;

    private Ladder ladder;
    private GameInfo gameInfo;

    public LadderGame(GameInfo gameInfo, int ladderHeight) {
        validate(ladderHeight);
        this.gameInfo = gameInfo;
        this.ladder = new Ladder(gameInfo, ladderHeight);
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public GameResults play() {
        List<GameResult> gameResult = new ArrayList<>();
        Players players = gameInfo.getPlayers();
        Prizes prizes = gameInfo.getPrizes();

        int playerCount = players.count();
        for (int i = 0; i < playerCount; i++) {
            int resultIndex = this.ladder.resultIndex(i);
            gameResult.add(new GameResult(players.getPlayer(i), prizes.getPrize(resultIndex)));
        }
        return new GameResults(gameResult);
    }

    private void validate(int ladderHeight) {
        if (ladderHeight < RULE_LADDER_HEIGHT_MIN_COUNT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 %d 이상이어야 합니다.", RULE_LADDER_HEIGHT_MIN_COUNT));
        }
    }
}
