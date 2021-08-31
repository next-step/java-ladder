package ladder.model;

import java.util.List;

public class LadderGame {

    private List<Player> players;
    private Ladder ladder;

    public LadderGame(List<Player> players, int height, MoveStrategy moveStrategy) {
        this.players = players;
        this.ladder = LadderFactory.create(players.size(), height, moveStrategy);
    }

    public List<Player> getPlayers(){
        return players;
    }

    public List<Line> getLadder(){
        return ladder.getLines();
    }
}
