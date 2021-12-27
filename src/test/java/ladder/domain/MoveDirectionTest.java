package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MoveDirectionTest {
    @Test
    void 첫번째_시작점_생성_왼쪽으로_이동불가하다() {
        MoveDirection first = MoveDirection.first(true);

        assertThat(first.canMoveLeft()).isFalse();
    }

    @Test
    void 양쪽으로_이동가능한경우는_생성할수없다() {
        assertThatThrownBy(() -> MoveDirection.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MoveDirection.CANNOT_MOVE_BOTH_SIDE_MESSAGE);
    }

    @Test
    void 마지막_생성_오른쪽으로_이동불가하다() {
        MoveDirection last = MoveDirection.first(true).last();

        assertThat(last.canMoveRight()).isFalse();
    }

    @Test
    void 왼쪽으로_이동가능한_경우() {
        MoveDirection next = MoveDirection.first(true).next(false);

        assertThat(next.canMoveLeft()).isTrue();
    }

    @Test
    void 오른쪽으로_이동가능한_경우() {
        MoveDirection next = MoveDirection.first(false).next(true);

        assertThat(next.canMoveRight()).isTrue();
    }

    @Test
    void 랜덤하게_첫번째_시작점_생성() {
        assertDoesNotThrow(() -> MoveDirection.first());
    }

    @Test
    void 랜덤하게_다음이동경우를_생성_왼쪽이동가능하면_오른쪽으로는_이동불가능하게_생성된다() {
        MoveDirection next = MoveDirection.first(true).next();

        assertThat(next.canMoveRight()).isFalse();
    }

    @Test
    void 랜덤하게_다음이동경우를_생성_왼쪽이동불가능하면_오른쪽은_자유롭게_생성된다() {
        assertDoesNotThrow(() -> MoveDirection.first(false).next());
    }
}
