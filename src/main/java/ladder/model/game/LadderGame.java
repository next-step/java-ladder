package ladder.model.game;

import ladder.model.Height;
import ladder.model.Line;
import ladder.model.Player;

import java.util.*;

public class LadderGame {

    private final List<Player> players;
    private final Height height;

    public LadderGame(List<Player> players, Height height) {
        this.players = players;
        this.height = height;
    }

    public List<Line> play() {
        List<Line> lineList = new ArrayList<Line>();
        for (int cnt = 0; cnt < height.get(); cnt++) {
            lineList.add(new Line(players.size()));
        }
        return lineList;
    }
}
