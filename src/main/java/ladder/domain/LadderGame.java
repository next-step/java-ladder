package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final Players players;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGame(Players players, Prizes prizes, Ladder ladder) {
        this.players = players;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public Map<Player, Prize> playGame() {
        Map<Player, Prize> ladderGameResult = new HashMap<>();

        for (int position = 0; position < players.getPlayerCount(); position++) {
            Player player = players.getPlayerByPosition(position);
            Prize prize = prizes.getPrizeByPosition(ladder.move(position));

            ladderGameResult.put(player, prize);
        }

        return ladderGameResult;
    }
}
