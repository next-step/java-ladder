package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @DisplayName("Direction 생성 테스트 - 좌, 우 방향이 모두 참이 아닌 경우 정상적으로 생성된다.")
    @Test
    void createDirectionTest() {
        Direction.of(false, true);
        Direction.of(true, false);
        Direction.of(false, false);
    }

    @DisplayName("Direction 생성 테스트 - 좌, 우 방향이 모두 참이면 예외가 발생한다.")
    @Test
    void createDirectionTestFail() {
        assertThatThrownBy(() -> Direction.of(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사다리의 한 행중 가장 앞 부분의 방향을 생성하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    void firstDirectionTest(boolean connected) {
        assertThat(Direction.first(() -> connected))
                .isEqualTo(Direction.of(false, connected));
    }

    @DisplayName("사다리의 한 행중 중간 부분의 방향을 생성하는 테스트 - 이전 방향이 right인 경우")
    @Test
    void middleDirectionTest() {
        Direction rightDirection = Direction.first(() -> true);
        assertThat(rightDirection.next(() -> true))
                .isEqualTo(Direction.of(true, false));
    }

    @DisplayName("사다리의 한 행중 중간 부분의 방향을 생성하는 테스트 - 이전 방향이 none인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    void middleDirectionTest(boolean connected) {
        Direction noneDirection = Direction.first(() -> false);
        assertThat(noneDirection.next(() -> connected))
                .isEqualTo(Direction.of(false, connected));
    }

    @DisplayName("사다리의 한 행중 마지막 부분의 방향을 생성하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    void lastDirectionTest(boolean connected) {
        Direction beforeLastDirection = Direction.of(false, connected);
        assertThat(beforeLastDirection.last())
                .isEqualTo(Direction.of(connected, false));
    }

    @DisplayName("방향이 왼쪽이면 True를 반환한다.")
    @Test
    void isLeftTest() {
        assertThat(Direction.of(true, false).isLeft())
                .isTrue();
    }

    @DisplayName("방향이 왼쪽이 아니면 False를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"false:false", "false:true"}, delimiter = ':')
    void isLeftTestFalse(boolean left, boolean right) {
        assertThat(Direction.of(left, right).isLeft())
                .isFalse();
    }

    @DisplayName("방향이 왼쪽이면 True를 반환한다.")
    @Test
    void isRightTest() {
        assertThat(Direction.of(false, true).isRight())
                .isTrue();
    }

    @DisplayName("방향이 오른쪽이 아니면 False를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"false:false", "true:false"}, delimiter = ':')
    void isRightTestFalse(boolean left, boolean right) {
        assertThat(Direction.of(left, right).isRight())
                .isFalse();
    }
}
