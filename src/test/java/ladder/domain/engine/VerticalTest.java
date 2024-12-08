package ladder.domain.engine;

import ladder.exception.VerticalException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.engine.Vertical.VERTICAL_IS_LESS_THEN_ZERO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class VerticalTest {

    @Test
    @DisplayName("사다리의 현재 높이를 생성한다")
    void create() {
        Vertical actual = new Vertical();
        Vertical expected = new Vertical(0);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("사다리의 현재 높이를 생성실패: 0보다 작을 수 없다")
    void create_실패_0보다_작을_수_없다() {
        assertThatThrownBy(() -> {
            new Vertical(-1);
        }).isInstanceOf(VerticalException.class)
                .hasMessage(VERTICAL_IS_LESS_THEN_ZERO);
    }

    @Test
    @DisplayName("사다리 높이를 이동시킨다")
    void moveDown() {
        Vertical vertical = new Vertical(1);
        Vertical actual = vertical.move();
        Vertical expected = new Vertical(2);

        assertThat(actual).isEqualTo(expected);
    }
}
