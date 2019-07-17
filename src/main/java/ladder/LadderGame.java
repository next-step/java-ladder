package ladder;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private Ladder ladder;
    private Players players;
    private Prizes prizes;

    public LadderGame(Ladder ladder, Players players, Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public ResultLadder startGame(String name) {
        int index = players.getIndex(name);
        int rank = ladder.runLadder(index);
        return ResultLadder.of(players.getPlayer(index), prizes.getPrize(rank));
    }

    public Map<Player, Prize> startGame() {
        Map<Player, Prize> resultLadders = new HashMap<>();
        for (int i = 0; i < players.getSize(); i++) {
            int rank = ladder.runLadder(i);
            resultLadders.put(players.getPlayer(i), prizes.getPrize(rank));
        }
        return resultLadders;
    }
}
