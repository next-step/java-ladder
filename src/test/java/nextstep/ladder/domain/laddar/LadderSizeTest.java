package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.exception.LadderSizeInitializeException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.laddar.LadderSize.MINIMUM_LENGTH;
import static nextstep.ladder.domain.laddar.LadderSize.of;
import static nextstep.ladder.fixture.LadderFixture.HEIGHT_SIZE_FIXTURE;
import static nextstep.ladder.fixture.LadderFixture.WIDTH_SIZE_FIXTURE;

/**
 * LadderSize는 사다리의 사이즈 정보를 갖는다. 사다리의 테두리는 사각형이다.
 */
class LadderSizeTest {
    private LadderSize ladderSize;

    @BeforeEach
    void setUp() {
        ladderSize = of(WIDTH_SIZE_FIXTURE, HEIGHT_SIZE_FIXTURE);
    }

    @MethodSource
    @ParameterizedTest
    @DisplayName("사다리 크기가 지정된 크기보다 작으면 초기화 예외를 발생시킨다.")
    void initException(final int width, final int height) {
        Assertions.assertThatThrownBy(() -> of(width, height))
                  .isInstanceOf(LadderSizeInitializeException.class)
                  .hasMessage(String.format("사다리 크기는 %d보다 커야 합니다.", MINIMUM_LENGTH));
    }

    private static Stream<Arguments> initException() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 0)
        );
    }

    @Test
    void getWidth() {
        Assertions.assertThat(ladderSize.width()).isEqualTo(WIDTH_SIZE_FIXTURE);
    }

    @Test
    void getHeight() {
        Assertions.assertThat(ladderSize.height()).isEqualTo(HEIGHT_SIZE_FIXTURE);
    }
}
