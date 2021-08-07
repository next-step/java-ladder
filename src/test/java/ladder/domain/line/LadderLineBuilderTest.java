package ladder.domain.line;

import ladder.domain.point.Direction;
import ladder.domain.point.RandomDirectionCreateStrategy;
import ladder.exception.OutOfSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLineBuilderTest {
    @DisplayName("수동 생성 테스트")
    @Test
    void manuelTest() {
        assertThatCode(() ->
            LadderLine.builder()
                    .manuel()
                    .next(Direction.RIGHT)
                    .next(Direction.LEFT)
                    .next(Direction.EMPTY)
                    .build()
        ).doesNotThrowAnyException();
    }

    @DisplayName("자동 생성 테스트 - 성공")
    @Test
    void autoTest() {
        assertThatCode(() ->
            LadderLine.builder()
                    .auto(new RandomDirectionCreateStrategy())
                    .pointSize(2)
                    .build()
        ).doesNotThrowAnyException();
    }

    @ValueSource(ints = {
            0, 1
    })
    @DisplayName("자동 생성 테스트 - 갯수가 최소 갯수 미만 일때")
    @ParameterizedTest
    void autoTest_OutOfSizeException(int pointSize) {
        assertThatThrownBy(() ->
            LadderLine.builder()
                    .auto(new RandomDirectionCreateStrategy())
                    .pointSize(pointSize)
                    .build()
        ).isInstanceOf(OutOfSizeException.class);
    }
}