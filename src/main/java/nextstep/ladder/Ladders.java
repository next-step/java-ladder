package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

    private final List<Line> lines = new ArrayList<>();

    private Ladders(int countOfPlayer, int maxHeight) {
        for (int i = 0; i < maxHeight; i++) {
            lines.add(new Line(countOfPlayer));
        }
    }

    public static Ladders makeLaddersByPlayersAndHeight(int countOfPlayer, int maxHeight) {
        return new Ladders(countOfPlayer, maxHeight);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
