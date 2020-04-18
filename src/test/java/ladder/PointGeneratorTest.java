package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointGeneratorTest {
    @DisplayName("PointGenerator 는 playCount 만큼 Point를 생성한다.")
    @Test
    void generate() {
        PointGenerator pointGenerator = new PointGenerator(3, () -> true);
        assertThat(pointGenerator.generate()).hasSize(3);
        assertThat(pointGenerator.generate()).containsExactly(
                new Point(0, Direction.of(FALSE, TRUE)),
                new Point(1, Direction.of(TRUE, FALSE)),
                new Point(2, Direction.of(FALSE, FALSE)));
    }
}
