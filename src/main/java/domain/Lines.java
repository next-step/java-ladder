package domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lines {

    private final List<Line> lines;
    private final int height;

    public Lines(final Players players, final int height) {
        lines = IntStream.range(0, height).mapToObj(i -> Line.from(players.size())).collect(toList());
        this.height = height;
    }

    public int move(int position) {
        for (int step = 0; step < this.height; step++) {
            position = this.lines.get(step).move(position);
        }
        return position;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final List<Line> lines = this.lines;
        for (int i = 0; i < lines.size(); i++) {
            sb.append(lines.get(i).toString());
            if (i < lines.size() - 1) sb.append("\n");
        }
        return sb.toString();
    }

}
