package nextstep.step2.vo;

import nextstep.step2.domain.Line;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private static final String EMPTY_MESSAGE = "Line 은 최대 한줄 이상입니다.";

    private final List<Line> lines;

    private Lines(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Lines create(List<Line> lines) {

        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }

        return new Lines(lines);
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::createWithLine)
                .collect(Collectors.toList());
    }
}
