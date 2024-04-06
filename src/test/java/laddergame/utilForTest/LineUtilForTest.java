package laddergame.utilForTest;

import laddergame.domain.ladder.Line;
import laddergame.domain.ladder.Link;

import java.util.List;

public class LineUtilForTest {
    public static Line newLine(Link... links) {
        return new Line(List.of(links));
    }
}
