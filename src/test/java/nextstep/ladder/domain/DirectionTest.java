package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DirectionTest {
    Direction toLeftDirection;
    Direction toRightDirection;
    Direction noneDirection;

    @BeforeEach
    void setUp() {
        toLeftDirection = new Direction(true, false);
        toRightDirection = new Direction(false, true);
        noneDirection = new Direction(false, false);
    }

    @Test
    @DisplayName("좌, 우 방향이 존재 유무를 가지는 좌표의 방향 객체 생성한다.")
    public void create() throws Exception {
        assertThat(noneDirection).isEqualTo(new Direction(false, false));
    }

    @Test
    @DisplayName("첫 번째 좌표의 방향 객체를 생성한다.")
    public void first() throws Exception {
        assertThat(Direction.first(() -> true)).isEqualTo(new Direction(false, true));
        assertThat(Direction.first(() -> false)).isEqualTo(new Direction(false, false));
    }

    @Test
    @DisplayName("좌, 우 방향이 모두 존재할 경우 예외가 발생한다.")
    public void validateContinuous() throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> new Direction(true, true)).withMessage("가로 라인이 겹치는 지 확인해주세요.");
    }

    @Test
    @DisplayName("현재 방향 객체 값을 기반으로 다음 방향 객체를 생성한다.")
    public void next() throws Exception {
        assertThat(toLeftDirection.next(() -> false)).isEqualTo(new Direction(false, false));
        assertThat(toLeftDirection.next(() -> true)).isEqualTo(new Direction(false, true));
        assertThat(toRightDirection.next()).isEqualTo(new Direction(true, false));
        assertThat(noneDirection.next(() -> true)).isEqualTo(new Direction(false, true));
        assertThat(noneDirection.next(() -> false)).isEqualTo(new Direction(false, false));
    }

    @Test
    @DisplayName("마지막 전 좌표를 기준으로 마지막 좌표의 방향 객체를 생성한다.")
    public void last() throws Exception {
        Direction leftTrue = toRightDirection.last();
        Direction leftFalse = noneDirection.last();
        assertThat(leftTrue).isEqualTo(new Direction(true, false));
        assertThat(leftFalse).isEqualTo(new Direction(false, false));
    }

    @Test
    @DisplayName("좌,우 둘 중 한 방향이라도 존재한다면 참을 반환한다.")
    public void hasAnyDirection() throws Exception {
        assertThat(toLeftDirection.hasAnyDirection()).isTrue();
        assertThat(toRightDirection.hasAnyDirection()).isTrue();
        assertThat(noneDirection.hasAnyDirection()).isFalse();
    }

    @Test
    @DisplayName("좌, 우 연결 방향에 따른 정수 값을 반환한다.")
    public void move() throws Exception {
        assertThat(toLeftDirection.move()).isEqualTo(-1);
        assertThat(toRightDirection.move()).isEqualTo(1);
        assertThat(noneDirection.move()).isEqualTo(0);
    }
}
