package nextstep.ladder.domain.ladder;

import nextstep.ladder.exception.OutOfRangeArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 타기시 위치를 표현하기 위한 클래스")
class LadderPositionTest {

    @DisplayName("사다리 위치는 숫자값을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(LadderPosition.from(5)).isInstanceOf(LadderPosition.class);
    }


    @DisplayName("사다리 위치는 음수가 될 수 없으며, 음수값이 들어올 경우 예외를 던진다")
    @Test
    void initException() {
        assertThatThrownBy(() -> LadderPosition.from(-1)).isInstanceOf(OutOfRangeArgumentException.class);
    }

    @DisplayName("객체 비교를 위한 equals 테스트")
    @MethodSource
    @ParameterizedTest
    void equals(int position, LadderPosition expectedPosition) {
        assertThat(LadderPosition.from(position)).isEqualTo(expectedPosition);
    }

    private static Stream<Arguments> equals() {
        return Stream.of(
                Arguments.of(0, LadderPosition.from(0)),
                Arguments.of(5, LadderPosition.from(5)),
                Arguments.of(10, LadderPosition.from(10))
        );
    }
}
