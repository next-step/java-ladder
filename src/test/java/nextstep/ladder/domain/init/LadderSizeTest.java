package nextstep.ladder.domain.init;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리의 크기를 정하는 초기화 정보")
class LadderSizeTest {

    @DisplayName("사다리 크기는 너비와 높이로 이루어진다")
    @Test
    void init() {
        assertThat(LadderSize.of(1, 2)).isInstanceOf(LadderSize.class);
    }

    @DisplayName("사다리 크기중 최소 길이가 안 되는 경우 예외를 발생시킨다")
    @MethodSource
    @ParameterizedTest
    void initException(int width, int height) {
        assertThatThrownBy(() -> LadderSize.of(width, height)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> initException() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0),
                Arguments.of(0, 0)
        );
    }
}
