package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private static final int ZERO = 0;

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder initLadder(Users users, Height height) {
        List<Line> lines = new ArrayList<>();

        IntStream.range(ZERO, height.getHeight())
                .forEach(number -> lines.add(Line.initLine(users)));
        return new Ladder(lines);
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public int getUserFinalIndex(User user) {
        int index = user.getIndex();
        for(Line line : lines) {
            int move = line.getPoints().get(index).getDirection().getMove();
            index += move;
        }

        return index;
    }

    public List<Line> getLines() {
        return lines;
    }
}
