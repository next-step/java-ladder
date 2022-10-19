package nextstep.laddar;

import java.util.ArrayList;
import java.util.List;

public class Laddar {

    List<Line> lines = new ArrayList<>();

    public Laddar(int height, int count, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(count));
        }

        for (Line line : lines) {
            line.makeHorizontalLines(booleanGenerator);
        }
    }
}
