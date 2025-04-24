package nextstep.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 사다리
 */
public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int column, int height) {
        List<Line> lines = IntStream.range(0, height) // 전체 행 지정
            .mapToObj(i -> Line.ofRandom(column)) // 전체 열 생성
            .collect(Collectors.toList());
        return new Ladder(lines);
    }

    /* 핵심 메서드 - 사다리 타기 */
    public int play(int index) {
        int position = index;
        for (Line line : lines) {
            position = line.move(position);
        }
        return position;
    }

    /* 정보제공 */
    public int height() {
        return lines.size();
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
