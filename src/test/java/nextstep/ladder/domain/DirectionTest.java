package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @DisplayName("Direction 생성 테스트 - 좌, 우 방향이 모두 참이 아닌 경우 정상적으로 생성된다.")
    @Test
    void createDirectionTest() {
        new Direction(false, true);
        new Direction(true, false);
        new Direction(false, false);
    }

    @DisplayName("Direction 생성 테스트 - 좌, 우 방향이 모두 참이면 예외가 발생한다.")
    @Test
    void createDirectionTestFail() {
        assertThatThrownBy(() -> new Direction(true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("방향이 왼쪽이면 True를 반환한다.")
    @Test
    void isLeftTest() {
        assertThat(new Direction(true, false).isLeft())
                .isTrue();
    }

    @DisplayName("방향이 왼쪽이 아니면 False를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"false:false", "false:true"}, delimiter = ':')
    void isLeftTestFalse(boolean left, boolean right) {
        assertThat(new Direction(left, right).isLeft())
                .isFalse();
    }

    @DisplayName("방향이 왼쪽이면 True를 반환한다.")
    @Test
    void isRightTest() {
        assertThat(new Direction(false, true).isRight())
                .isTrue();
    }

    @DisplayName("방향이 오른쪽이 아니면 False를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"false:false", "true:false"}, delimiter = ':')
    void isRightTestFalse(boolean left, boolean right) {
        assertThat(new Direction(left, right).isRight())
                .isFalse();
    }
}
