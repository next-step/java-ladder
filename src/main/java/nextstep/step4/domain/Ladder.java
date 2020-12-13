package nextstep.step4.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder init(int numberOfUsers, int height) {
        List<Line> lines = new ArrayList<>(height);

        IntStream.range(0, height)
                .forEach(row -> lines.add(Line.init(numberOfUsers)));

        return new Ladder(lines);
    }

    public static Ladder from(List<Line> lines) {
        return new Ladder(lines);
    }

    public int move(int position) {
        int current = position;
        for(Line line : lines) {
            current = line.move(current);
        }
        return current;
    }

    public int getUserFinalIndex(User user) {
        int index = user.getIndex();
        for(Line line : lines) {
            index = line.move(index);
        }

        return index;
    }

    public List<Line> getLines() {
        return lines;
    }
}
