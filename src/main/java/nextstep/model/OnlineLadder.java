package nextstep.model;

import java.util.HashMap;
import java.util.Map;

import static nextstep.constant.Constant.ALL;

public class OnlineLadder extends Ladder {
    private final Lines lines;
    private final Players players;
    private Map<Player, Integer> result;

    public OnlineLadder(int maxVertical, int countOfPerson, String[] names) {
        this.lines = new Lines(maxVertical, countOfPerson);
        this.players = new Players(names);
        this.lineMarkAll();
        this.result = new HashMap<>();
    }

    public void lineMarkAll() {
        this.lines.initMark();
        this.lines.markWithoutFirst();
    }

    public Points points(int row) {
        return this.lines.points(row);
    }

    public Players players() {
        return players;
    }

    public int start(Player whoWinner) {
        if (whoWinner.equals(ALL)) {

        }
        int playerIndex = this.filter(whoWinner);
        if (playerIndex < 0) {
            throw new IllegalArgumentException("No user");
        }
        int playerResult = this.lines.start(playerIndex);
        result.put(whoWinner, playerResult);
        return playerResult;
    }

    public int filter(Player playerName) {
        return this.players.filter(playerName);
    }
}
