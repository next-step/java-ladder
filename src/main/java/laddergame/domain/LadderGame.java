package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final LadderResult ladderResult;

    public LadderGame(Players players, Ladder ladder, LadderResult ladderResult) {
        this.players = players;
        this.ladder = ladder;
        this.ladderResult = ladderResult;
    }

    public LadderPlayResult play() {
        Map<Player, String> playResults = new LinkedHashMap<>();

        for (int position = 0; position < players.size(); position++) {
            Player player = players.findByPosition(position)
                    .orElseThrow(() -> new IllegalStateException("존재하지 않는 사용자입니다"));
            int finalPosition = ladder.moveDownByPosition(position);
            String gameResult = ladderResult.findBy(finalPosition);
            playResults.put(player, gameResult);
        }
        return new LadderPlayResult(playResults);
    }
}
