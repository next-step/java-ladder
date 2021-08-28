package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final Players players;

    private Ladder(List<Line> lines, Players players) {
        this.lines = lines;
        this.players = players;
    }

    public static Ladder of(Players players, LadderHeight heightOfLadder) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < heightOfLadder.height(); i++) {
            List<Boolean> points = new RandomPointStrategy().point(players.size() - 1);
            lines.add(Line.from(points));
        }

        return new Ladder(lines, players);
    }

    public static Ladder of(Line lines, Players players) {
        return new Ladder(Collections.singletonList(lines), players);
    }

    public List<Line> lines() {
        return lines;
    }

    public Players players() {
        return players;
    }

    public void movePlayer(Player player) {
        for (Line line : lines()) {
            Position position = player.position();
            if (line.canGoRight(position)) {
                player.move(position.toRight());
            } else if (line.canGoLeft(position)) {
                player.move(position.toLeft());
            }
        }
    }

    public Player findPlayerByName(String name) {
        return players.findIndexByName(name);
    }

}
