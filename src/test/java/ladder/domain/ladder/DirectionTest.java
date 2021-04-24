package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("Direction 인스턴스에 첫번째 지점 생성 테스트")
    @Test
    void 생성_첫_Direction() {
        // given
        boolean current = true;

        // when
        Direction direction = Direction.first(current);

        // then
        assertThat(direction.heading()).isEqualTo(Heading.RIGHT);
    }

    @DisplayName("Direction 인스턴스가 다음 지점 Point 인스턴스 생성 테스트")
    @Test
    void 기능_다음_Direction_생성_이전이_FALSE() {
        // given
        boolean current = false;

        // when
        Direction direction = Direction.first(current).next(() -> true);

        // then
        assertThat(direction.heading()).isEqualTo(Heading.RIGHT);
    }

    @DisplayName("Direction 인스턴스가 이전이 true 일때, false를 가진 다음 Point 인스턴스 생성 테스트")
    @Test
    void 기능_다음_Direction_생성_이전이_TRUE() {
        // given
        boolean current = true;

        // when
        Direction direction = Direction.first(current).next(() -> false);

        // then
        assertThat(direction.heading()).isEqualTo(Heading.LEFT);
    }

    @DisplayName("Direction 인스턴스에 마지막 지점 생성 테스트")
    @Test
    void 생성_마지막_Direction() {
        // given
        boolean current = true;

        // when
        Direction direction = Direction.first(current).next(() -> false).last();

        // then
        assertThat(direction.heading()).isEqualTo(Heading.PASS);
    }

    @DisplayName("Direction 인스턴스의 다음 이동이 Direction.LEFT 인지 확인")
    @Test
    void 검증_왼쪽() {
        // given
        boolean current = true;

        // when
        Direction direction = Direction.first(current).next(() -> false);

        // then
        assertThat(direction.heading()).isEqualTo(Heading.LEFT);
    }

    @DisplayName("Direction 인스턴스의 다음 이동이 Direction.RIGHT 인지 확인")
    @Test
    void 검증_오른쪽() {
        // given
        boolean current = false;

        // when
        Direction direction = Direction.first(current).next(() -> true);

        // then
        assertThat(direction.heading()).isEqualTo(Heading.RIGHT);
    }

    @DisplayName("Direction 인스턴스의 다음 이동이 Direction.PASS 인지 확인")
    @Test
    void 검증_지나가기() {
        // given
        boolean current = false;

        // when
        Direction direction = Direction.first(current).next(() -> false);

        // then
        assertThat(direction.heading()).isEqualTo(Heading.PASS);
    }

    @DisplayName("Direction 인스턴스가 값을 기준으로 동일한 인스턴스인지 판단 여부 테스트")
    @Test
    void 비교() {
        // given
        boolean current = false;

        // when
        Direction actual = Direction.first(current);
        Direction expected = Direction.first(current);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}