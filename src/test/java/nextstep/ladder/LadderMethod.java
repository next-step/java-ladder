package nextstep.ladder;

import nextstep.ladder.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

public class LadderMethod {

    public static List<Line> toLines(List<Boolean> lines) {
        return lines.stream()
                .map(isLine -> new Line(isLine))
                .collect(Collectors.toList());
    }
}
