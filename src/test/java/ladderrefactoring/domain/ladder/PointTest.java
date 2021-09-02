package ladderrefactoring.domain.ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Point 생성")
    void create() {
        // when
        Point point = new Point(2, false, false);
        // then
        assertThat(point).isEqualTo(new Point(2, false, false));
    }

    @ParameterizedTest(name = "Point 이동 [{index}] {0} {1} {2} -> {3}")
    @CsvSource({"2, false, false, 2", "2, true, false, 1", "2, false, true, 3"})
    void move(int index, boolean left, boolean right, int result) {
        // when
        Point point = new Point(index, left, right);
        // then
        assertThat(point.move()).isEqualTo(result);
    }

}