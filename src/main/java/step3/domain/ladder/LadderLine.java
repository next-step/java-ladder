package step3.domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LadderLine {
    private final List<LadderPoint> line;

    private static final int MAX_SIZE = 5;

    public LadderLine(List<LadderPoint> line) {
        this.line = line;
    }

    public static LadderLine of(int size) {
        validateSize(size);
        return new LadderLine(makeRandomLine(size));
    }

    private static void validateSize(int size) {
        if (moreThanMax(size)) {
            throw new RuntimeException("최대 참여자는 5명을 넘을 수 없습니다.");
        }

        if (lessThanMin(size)) {
            throw new RuntimeException("참여자는 최소 1명 이상이여야 합니다.");
        }
    }

    private static boolean moreThanMax(int size) {
        return size > MAX_SIZE;
    }

    private static boolean lessThanMin(int size) {
        return size <= 0;
    }

    private static List<LadderPoint> makeRandomLine(int size) {
        return adjustLast(Stream.iterate(LadderPoint.makeRandomPoint(LadderPoint.NONE), LadderPoint::makeRandomPoint)
            .limit(size)
            .collect(Collectors.toList()), size - 1);
    }

    private static List<LadderPoint> adjustLast(List<LadderPoint> list, int lastIndex) {
        if (list.get(lastIndex) == LadderPoint.RIGHT) {
            list.set(lastIndex, LadderPoint.NONE);
        }

        return list;
    }

    public List<LadderPoint> getLine() {
        return Collections.unmodifiableList(line);
    }

    @Override
    public String toString() {
        return line.stream()
            .map(LadderPoint::toString)
            .collect(Collectors.joining(""));
    }

    public int move(int position) {
        return line.get(position).move(position);
    }
}
