package nextstep.ladder.domain;

import java.util.*;

public class LadderGame {
    private static final String LADDER_GAME_ERROR = "결과 수와 참여자 수는 같아야 합니다.";
    private final Players players;
    private final Ladder ladder;

    private LadderGame(final Players players, final Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public static LadderGame of(final List<String> players, final Ladder ladder) {
        return new LadderGame(new Players(players), ladder);
    }

    public LadderResults climbLadder(Results results) {
        if (!players.isSameSize(results)) {
            throw new IllegalArgumentException(LADDER_GAME_ERROR);
        }

        Map<String, String> resultMap = new LinkedHashMap<>();
        for (int location = 0; location < results.size(); location++) {
            int index = ladder.climbLadder(location);
            resultMap.put(players.indexOf(location), results.indexOf(index));
        }
        return new LadderResults(resultMap);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }
}
