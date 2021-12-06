package ladder.game;

import ladder.model.Height;
import ladder.model.Line;
import ladder.model.player.Players;

import java.util.*;

public class LadderGame {

    private final Players players;
    private final Height height;

    public LadderGame(Players players, Height height) {
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
