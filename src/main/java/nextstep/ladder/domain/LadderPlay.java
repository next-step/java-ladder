package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderPlay {
    private static final String LADDER_GAME_ERROR = "결과 수와 참여자 수는 같아야 합니다.";
    private final Players players;
    private final Ladder ladder;

    private LadderPlay(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static LadderPlay of(Players players, final Ladder ladder) {
        return new LadderPlay(players, ladder);
    }

    public GameResults climbLadder(LadderResults ladderResults) {
        if (!players.validResultCount(ladderResults)) {
            throw new IllegalArgumentException(LADDER_GAME_ERROR);
        }

        Map<String, String> resultMap = new LinkedHashMap<>();
        for (int location = 0; location < ladderResults.countOfLadderResults(); location++) {
            int index = ladder.climbLadder(location);
            resultMap.put(players.indexOf(location), ladderResults.indexOf(index));
        }
        return new GameResults(resultMap);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }
}
