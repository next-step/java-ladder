package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("사람 수에 따라 라인이 생성된다.")
    @Test
    void create() {
        Line line = new Line(3, () -> false);

        assertThat(line.getLine()).hasSize(3);
        assertThat(line.getLine())
                .containsExactly(
                        Direction.first(false),
                        Direction.first(false).next(false),
                        Direction.first(false).next(false).last()
                );
    }
}