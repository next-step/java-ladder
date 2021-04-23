package ladder.domain.ladder;

import ladder.exception.InputNegativeNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("Point 인스턴스가 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int position = 0;
        Direction direction = Direction.first(false);

        // when
        Point point = Point.from(position, direction);

        // then
        assertThat(point).isNotNull();
    }

    @DisplayName("Point 인스턴스 position 값으로 음수 입력시 예외처리 여부 테스트")
    @Test
    void 검증_음수() {
        // given
        int position = -1;
        Direction direction = Direction.first(false);

        // when
        assertThatThrownBy(() -> Point.from(position, direction))
                .isInstanceOf(InputNegativeNumberException.class)
                .hasMessage("(-1)이라는 음수의 값이 입력되었습니다.");
    }


    @DisplayName("Point 인스턴스 position 값으로 null 입력시 예외처리 여부 테스트")
    @Test
    void 검증_null() {
        // given
        int position = 0;
        Direction direction = null;

        // when
        assertThatThrownBy(() -> Point.from(position, direction))
                .isInstanceOf(InputNegativeNumberException.class)
                .hasMessage("Direction이 null 입니다.");
    }


    @DisplayName("Point 인스턴스가 오른쪽으로 이동하는지 테스트")
    @Test
    void 기능_오른쪽_이동() {
        // given
        int position = 1;
        int executed = 2;
        Direction right = Direction.first(true);

        // when
        Point point = Point.from(position, right);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }

    @DisplayName("Point 인스턴스가 왼쪽으로 이동하는지 테스트")
    @Test
    void 기능_왼쪽_이동() {
        // given
        int position = 1;
        int executed = 0;
        Direction left = Direction.first(true).next(false);

        // when
        Point point = Point.from(position, left);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }


    @DisplayName("Point 인스턴스가 그대로 아래로 이동하는지 테스트")
    @Test
    void 기능_아래로_이동() {
        // given
        int position = 1;
        int executed = 1;
        Direction pass = Direction.first(false);

        // when
        Point point = Point.from(position, pass);

        // then
        assertThat(point.move()).isEqualTo(executed);
    }


}