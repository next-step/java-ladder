package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;

    @BeforeEach
    void init() {
        List<Point> points = List.of(
                new Point(false), new Point(false), new Point(true), new Point(false), new Point(true));

        line = new Line(5, countOfPlayer -> points);
    }

    @Test
    void 라인_출력() {
        String result = line.toString();

        assertThat(result).isEqualTo("      |      |------|      |------|");
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"0:0", "1:2", "2:1", "3:4", "4:3"})
    void move_테스트(int pointIndex, int expected) {
        int resultIdx = line.move(pointIndex);

        assertThat(resultIdx).isEqualTo(expected);
    }
}
