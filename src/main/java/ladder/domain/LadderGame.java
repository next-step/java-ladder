package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final List<String> playerNames;
    private final List<String> results;

    public LadderGame(Players players, ResultGoods resultGoods) {
        this.playerNames = players.getPlayerNames();
        this.results = resultGoods.getResults();
    }

    public List<ResultOfPlayer> gameResult(Ladder ladder, int countOfPerson) {
        List<ResultOfPlayer> resultOfPlayers = new ArrayList<>();
        for (int idx = 0; idx < countOfPerson; idx++) {
            int result = ladder.move(idx);
            resultOfPlayers.add(new ResultOfPlayer(playerNames.get(idx), results.get(result)));
        }
        return resultOfPlayers;
    }
}
