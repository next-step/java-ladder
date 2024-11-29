package nextstep.ladder.factory;

import java.util.ArrayList;
import java.util.List;
import nextstep.ladder.domain.LineImpl;
import nextstep.ladder.interfaces.Line;

public class LinesDataConverter {
    static List<Line> convert(List<Boolean> points) {
        return toPoints(points);
    }

    private static List<Line> toPoints(List<Boolean> lines) {
        ArrayList<Line> result = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            result.add(new LineImpl(lines.get(i), i));
        }
        return result;
    }
}
