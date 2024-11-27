package nextstep.ladder.util;

import java.util.List;
import java.util.stream.IntStream;
import nextstep.ladder.domain.Line;

public class ConsecutiveChecker {
    public static boolean isConsecutive(List<Boolean> lines) {
        return IntStream.range(0, lines.size() - 1).anyMatch(i -> lines.get(i) && lines.get(i + 1));
    }

    public static boolean isConsecutiveLine(List<Line> lines) {
        return IntStream.range(0, lines.size() - 1).anyMatch(i -> lines.get(i).connected(lines.get(i + 1)));
    }
}
