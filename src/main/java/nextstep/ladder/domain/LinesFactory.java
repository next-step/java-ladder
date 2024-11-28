package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinesFactory {
    public static Lines lines(List<Boolean> lines) {
        return new Lines(PointConverter.convert(lines));
    }

    public static Lines lines(Boolean... lines) {
        return lines(toList(lines));
    }

    private static List<Boolean> toList(Boolean[] lines) {
        return Arrays.asList(lines);
    }

    private static class PointConverter {
        private static List<Line> convert(List<Boolean> points) {
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
}
