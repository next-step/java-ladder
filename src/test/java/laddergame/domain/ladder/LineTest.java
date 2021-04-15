package laddergame.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private static final int COUNT_OF_PERSON = 6;
    private Size size = new Size(5, COUNT_OF_PERSON);
    private Line line;
    private List<Point> points = new ArrayList<>();

    @BeforeEach
    void setUp() {
        line = new Line(size);
        IntStream.range(0, COUNT_OF_PERSON)
                .forEach(i -> points.add(new Point()));
    }

    @Test
    void 라인의선을_이웃하지않게_생성() {
        line = new Line(points);
        line.connect(() -> true);

        points.forEach(point ->
                assertThat(point.isLinked()).isTrue());
        assertThat(line.isConnect()).containsAll(Collections.singleton(true));
    }

    @Test
    void 라인의선을_생성하지않음() {
        line = new Line(points);
        line.connect(() -> false);

        points.forEach(point ->
                assertThat(point.isLinked()).isFalse());
        assertThat(line.isConnect()).containsAll(Collections.singleton(false));
    }

}
