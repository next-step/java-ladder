package domain;

import ladder.domain.LadderDirection;
import ladder.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LadderDirectionTest {

    private LadderDirection direction;

    @Test
    @DisplayName("오른쪽으로 이동했는지")
    void moveRight() {
        direction = new LadderDirection(false, true);

        assertThat(1).isEqualTo(direction.move());
    }

    @Test
    @DisplayName("왼쪽으로 이동했는지")
    void moveLeft() {
        direction = new LadderDirection(true, false);

        assertThat(-1).isEqualTo(direction.move());
    }

    @Test
    @DisplayName("정지했는지")
    void moveStop() {
        direction = new LadderDirection(false, false);

        assertThat(0).isEqualTo(direction.move());
    }

    @Test
    @DisplayName("왼쪽 오른쪽이 true경우 에러를 발생한다.")
    void moveErrorCheck() {
        assertThatThrownBy(() ->
                direction = new LadderDirection(true, true)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(ErrorMessage.getCheckDirection());

    }
}
