package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    @DisplayName("Line의 사이즈는 참가인원보다 1 적어야 한다.")
    void lineCreateTest() {
        CountOfPerson countOfPerson = new CountOfPerson(4);
        Line line = new Line(countOfPerson);
        assertThat(line.size()).isEqualTo(countOfPerson.value - 1);
    }

    @Test
    @DisplayName("Line의 point값은 연속으로 true가 나오면 안된다.")
    void linePointerTest() {
        CountOfPerson countOfPerson = new CountOfPerson(10_000);
        Line line = new Line(countOfPerson);
        List<Boolean> points = line.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i)) {
                assertThat(points.get(i + 1)).isFalse();
            }
        }
    }
}
