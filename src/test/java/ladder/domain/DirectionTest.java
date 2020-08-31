package ladder.domain;

import ladder.exception.LadderExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionTest {

    @DisplayName("Direction 생성 테스트")
    @Test
    void of() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("Direction 생성 (left,right 둘 다 true인 경우) 테스트")
    @Test
    void of_invalid() {
        String expectedMessage = LadderExceptionMessage.INVALID_LINE_DIRECTION_INPUT;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Direction.of(true, true))
                .withMessage(expectedMessage);
    }

    @DisplayName("Direction 첫번째 방향 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    public void getFirst(boolean right) {
        Direction first = Direction.getFirst(right);

        assertThat(first.isLeft()).isFalse();
        assertThat(first.isRight()).isEqualTo(right);
    }


    @DisplayName("Direction 마지막 방향 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    public void getLast(boolean left) {
        Direction last = Direction.getLast(left);

        assertThat(last.isLeft()).isEqualTo(left);
        assertThat(last.isRight()).isFalse();
    }

    @DisplayName("이전 방향의 right가 true인 경우 next Direction 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"false:true:false", "false:true:true"}, delimiter = ':')
    public void next_true_right(boolean left, boolean right, boolean nextRight) {
        Direction origin = Direction.of(left, right);
        Direction next = origin.next(nextRight);

        assertThat(next.isLeft()).isEqualTo(origin.isRight());
        assertThat(next.isRight()).isFalse();
    }

    @DisplayName("이전 방향의 right가 false인 경우 next Direction 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:false:true", "true:false:false", "false:false:true", "false:false:false"}, delimiter = ':')
    public void next_false_right(boolean left, boolean right, boolean nextRight) {
        Direction origin = Direction.of(left, right);
        Direction next = origin.next(nextRight);

        assertThat(next.isLeft()).isEqualTo(origin.isRight());
        assertThat(next.isRight()).isEqualTo(nextRight);
    }

}
