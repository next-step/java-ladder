package ladder.service;

import ladder.model.Ladder;
import ladder.model.Line;
import ladder.model.Players;

import java.util.List;

public class LadderGame {
    public static final String COMMA =",";
    private Players players;
    private Ladder ladder;

    public LadderGame() {
        ladder = new Ladder();
    }

    public void setPlayer(String[] names) {
        this.players = new Players(names);
    }

    public void setHeight(int height) {
        ladder.setHeight(height);
    }

    public Players getPlayers() {
        return players;
    }

    public void makeLine() {
        ladder.makeLine(players.getNumPlayers());
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
