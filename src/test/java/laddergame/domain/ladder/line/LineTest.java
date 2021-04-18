package laddergame.domain.ladder.line;

import laddergame.domain.ladder.Size;
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
        IntStream.range(0, COUNT_OF_PERSON)
                .forEach(i -> points.add(new Point()));
        line = new Line(points);
    }

    @Test
    void 라인의선을_이웃하지않게_생성() {
        line.connect(() -> true);

        points.forEach(point ->
                assertThat(point.isLinked()).isTrue());
        assertThat(line.isConnect()).containsAll(Collections.singleton(true));
    }

    @Test
    void 라인의선을_생성하지않음() {
        line.connect(() -> false);

        points.forEach(point ->
                assertThat(point.isLinked()).isFalse());
        assertThat(line.isConnect()).containsAll(Collections.singleton(false));
    }

    @Test
    void 한칸을이동() {
        line.connect(() -> true);

        int index = line.moveOne(1);
        int index2 = line.moveOne(0);
        assertThat(index).isEqualTo(0);
        assertThat(index2).isEqualTo(1);
    }

    @Test
    void 한칸을이동하지않음() {
        line.connect(() -> false);

        int index = line.moveOne(1);
        int index2 = line.moveOne(0);
        assertThat(index).isEqualTo(1);
        assertThat(index2).isEqualTo(0);
    }
}
