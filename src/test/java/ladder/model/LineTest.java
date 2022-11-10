package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("라인은 사람 수 만큼 방향을 갖는다")
    @Test
    void create() {
        Line line = new Line(3, () -> false);

        assertThat(line.getDirections()).hasSize(3);
        assertThat(line.getDirections())
                .containsExactly(
                        Direction.first(false),
                        Direction.first(false).next(false),
                        Direction.first(false).next(false).last()
                );
    }
}
