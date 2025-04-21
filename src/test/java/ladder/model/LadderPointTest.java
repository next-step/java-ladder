package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LadderPointTest {

    @Test
    void 이동_양쪽없음() {
        LadderPoint point = LadderPoint.of(false, false);
        assertThat(point.move()).isEqualTo(LadderDirection.STAY);
    }

    @Test
    void 이동_왼쪽() {
        LadderPoint point = LadderPoint.of(true, false);
        assertThat(point.move()).isEqualTo(LadderDirection.LEFT);
    }

    @Test
    void 이동_오른쪽() {
        LadderPoint point = LadderPoint.of(false, true);
        assertThat(point.move()).isEqualTo(LadderDirection.RIGHT);
    }

    @Test
    void 양방향_불가() {
        assertThatThrownBy(() -> {
            LadderPoint.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("왼쪽과 오른쪽 모두 true일 수 없습니다.");

        assertThatThrownBy(() -> {
            LadderPoint.first(true).next(true);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("왼쪽과 오른쪽 모두 true일 수 없습니다.");
    }

    @Test
    void first() {
        LadderPoint point = LadderPoint.first(true);
        assertThat(point).isEqualTo(LadderPoint.of(false, true));
    }

    @Test
    void next() {
        LadderPoint point = LadderPoint.first(false);
        LadderPoint nextPoint = point.next(true);
        assertThat(nextPoint).isEqualTo(LadderPoint.of(false, true));
    }

    @Test
    void last() {
        LadderPoint point = LadderPoint.of(false, true);
        LadderPoint lastPoint = point.last();
        assertThat(lastPoint).isEqualTo(LadderPoint.of(true, false));
    }

}