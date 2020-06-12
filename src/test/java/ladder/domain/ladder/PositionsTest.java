package ladder.domain.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PositionsTest {

    private List<Position> positions;

    @BeforeEach
    void setUp() {
        positions = Arrays.asList(Position.of(2), Position.of(0), Position.of(1));
    }

    @DisplayName("Positions 생성 실패: null 인 값")
    @ParameterizedTest
    @NullSource
    void createFailure(final List<Position> positions) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Positions.of(positions));
    }

    @DisplayName("특정 순서의 위치값을 반환")
    @ParameterizedTest
    @MethodSource
    void indexOf(final int index, final Position expected) {
        assertThat(Positions.of(positions).indexOf(index))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> indexOf() {
        return Stream.of(
                Arguments.of(0, Position.of(2)),
                Arguments.of(1, Position.of(0)),
                Arguments.of(2, Position.of(1))
        );
    }
}
