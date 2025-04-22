package nextstep.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    @DisplayName("한 라인에는 인접한 True가 없어야 한다.")
    void adjacentPointTest() {
        Line line = Line.ofColumn(5);
        line.generateRandomStatus();
        List<Boolean> points = line.rowStatus();
        System.out.println("points = " + points);
        IntStream.range(0, points.size() - 1)
            .filter(points::get)
            .forEach(i -> assertFalse(points.get(i + 1)));
    }
}
