package nextstep.ladder2;

import nextstep.ladder2.player.Players;
import nextstep.ladder2.result.Results;

public class InputData {

    private int height = 0;
    private Players players;
    private Results results;

    public InputData(Players players, Results results, int height) {
        this.players = players;
        this.results = results;
        this.height = height;
    }

    public static InputData of(Players players, Results results, int height) {
        return new InputData(players, results, height);
    }

    public int height() {
        return height;
    }

    public int playerSize() {
        return players.size();
    }

    public Players players() {
        return players;
    }

    public Results results(){
        return results;
    }
}
