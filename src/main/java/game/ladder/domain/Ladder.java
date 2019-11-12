package game.ladder.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yusik on 2019/11/11.
 */
public class Ladder {

    private List<Line> lines = new ArrayList<>();
    private List<String> players;

    public Ladder(List<String> names, int height) {
        players = names;
        int countOfPlayer = players.size();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPlayer));
        }
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<Line> getLines() {
        return lines;
    }
}
