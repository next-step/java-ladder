package domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines;

    protected Lines(final List<Line> lines) {
        this.lines = lines;
    }

    public static Lines of(final Length width, final Length height) {
        List<Line> lines = new ArrayList<>();
        int heightOfLadder = height.value();

        for(int i = 0; i < heightOfLadder; i++) {
            lines.add(Line.of(width));
        }

        return new Lines(lines);
    }

    public List<Line> unbox() {
        return lines;
    }

    public Position departsAt(final Position start) {
        Position position = start;

        for(int i = 0; i < lines.size(); i++) {
            position = lines.get(i).move(position);
        }

        return position;
    }

}
