package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @DisplayName("객체 생성 테스트")
    @Test
    void create() {
        Line line = Line.of(2, () -> true);

        assertThat(line).isNotNull();
    }

    @DisplayName("사다리 한줄이 의도적으로 생성되었는지 테스트")
    @Test
    void createLineAllTrue() {
        Point pointTrue = new Point(true);
        Point pointFalse = new Point(false);
        List<Point> excepted = Arrays.asList(pointFalse, pointTrue, pointFalse, pointTrue);

        Line line = Line.of(4, () -> true);
        List<Point> actual = line.getLine();

        assertThat(actual.size()).isEqualTo(excepted.size());

        for (int i =0; i < actual.size(); i++) {
            assertThat(actual.get(i)).isEqualTo(excepted.get(i));
        }
    }
}
