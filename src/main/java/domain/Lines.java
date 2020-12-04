package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Lines {
    private List<Line> lines;

    private Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final Length width, final Length height) {
        List<Line> lines = new ArrayList<>();
        int heightOfLadder = height.getValue();

        for(int i = 0; i < heightOfLadder; i++) {
            lines.add(Line.of(width));
        }

        return new Lines(lines);
    }

    public Stream<Points> mapLineOntoPoints() {
        return lines.stream().map(Line::getPoints);
    }

    public int departsAt(int start) {
        int position = start;

        for(int i = 0; i < lines.size(); i++) {
            position = lines.get(i).move(position);
        }

        return position;
    }

}
