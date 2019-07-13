package ladder;

import java.util.ArrayList;
import java.util.List;

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
        return ResultLadder.of(players.getPlayers().get(index), prizes.getPrizes().get(rank));
    }

    public List<ResultLadder> startGame() {
        List<ResultLadder> resultLadders = new ArrayList<>();
        for (int i = 0; i < players.getSize(); i++) {
            int rank = ladder.runLadder(i);
            resultLadders.add(ResultLadder.of(players.getPlayers().get(i), prizes.getPrizes().get(rank)));
        }
        return resultLadders;
    }
}
