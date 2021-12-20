package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @Test
    void 왼쪽으로_이동() {
        Direction left = new Direction(true, false);
        assertThat(left.move()).isEqualTo(-1);
    }

    @Test
    void 오른쪽으로_이동() {
        Direction right = new Direction(false, true);
        assertThat(right.move()).isEqualTo(1);
    }

    @Test
    void 제자리() {
        Direction center = new Direction(false, false);
        assertThat(center.move()).isEqualTo(0);
    }

    @DisplayName("UI에서 사다리를 그리기 위한 테스트")
    @Test
    void 오른쪽으로_이동_여부() {
        Direction direction = new Direction(false, true);
        assertThat(direction.isRight()).isTrue();
    }

    @Test
    void 왼쪽_오른쪽_동시_이동_불가() {
        // when
        assertThatThrownBy(() -> new Direction(true, true))
                // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌,우 동시에 이동할 수 없습니다.");
    }
}