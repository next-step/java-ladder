package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositionTest {

    private final int currentPosition = 1;
    private Position position = Position.from(currentPosition);

    @Test
    void 플레이어의_현재_위치를_생성한다() {
        assertThat(position.isSameWith(1)).isTrue();
    }

    @Test
    void 위치를_오른쪽으로_1만큼_이동한다() {
        assertThat(position.moveToRight().getPosition()).isEqualTo(currentPosition + 1);
    }

    @Test
    void 위치를_왼쪽으로_1만큼_이동한다() {
        assertThat(position.moveToLeft().getPosition()).isEqualTo(currentPosition - 1);
    }

    @Test
    void 현재_위치보다_1만큼_작은_위치를_반환한다() {
        assertThat(position.getLeftPosition()).isEqualTo(currentPosition - 1);
    }

    @Test
    void 현재_위치가_0보다_크지_않으면_왼쪽으로_이동할_경우_예외가_발생한다() {
        int position = 0;
        Position testPosition = Position.from(position);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(testPosition::moveToLeft)
                .withMessage(Position.ALERT_UNMOVABLE_TO_LEFT);
    }
}
