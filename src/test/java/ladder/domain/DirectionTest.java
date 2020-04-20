package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class DirectionTest {
    @DisplayName("초기화 테스트")
    @Test
    void create() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("첫번째 Direction의 left는 항상 False 이다.")
    @Test
    void firstByCreation() {
        assertThat(Direction.first(TRUE).isLeft()).isFalse();
        assertThat(Direction.first(FALSE).isLeft()).isFalse();
    }

    @DisplayName("마지막 Direction의 right는 항상 False 이다.")
    @Test
    void lastByCreation() {
        Direction direction = Direction.of(TRUE, FALSE);
        assertThat(direction.last().isRight()).isFalse();

        direction = Direction.of(FALSE, TRUE);
        assertThat(direction.last().isRight()).isFalse();
    }

    @DisplayName("n번째 Direction의 right는 n+1 번째 Direction의 left 이다.")
    @Test
    void chainByCreation() {
        assertThat(Direction.of(TRUE, FALSE).next(TRUE).isLeft()).isFalse();
    }

    @DisplayName("n번째 Direction의 right가 True이면 n+1번째 right는 False이다.")
    @Test
    void relationByCreation() {
        assertThat(Direction.of(FALSE, TRUE).next(TRUE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("Direction의 left와 right 모두 True 일 수 없다.")
    @Test
    void exceptByCreation() {
        assertThatIllegalStateException().isThrownBy(() -> {
            Direction.of(TRUE, TRUE);
        });
    }
}
