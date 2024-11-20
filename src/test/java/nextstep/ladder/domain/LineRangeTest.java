package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LineRangeTest {

    @ParameterizedTest
    @MethodSource("swapResult")
    void left의_바로다음숫자와_값을_스왑한다(int left, List<Integer> result) {
        LineRange lineRange = new LineRange(left);
        Position position = new Position(List.of(0, 1, 2));

        lineRange.swap(position);

        assertThat(position).isEqualTo(new Position(result));

    }

    @Test
    void 스왑하려는_위치가_없으면_예외를_발생시킨다() {
        LineRange lineRange = new LineRange(1);

        assertThatIllegalArgumentException().isThrownBy(() -> lineRange.swap(new Position(List.of(0, 1))));
    }

    private static Stream<Arguments> swapResult() {
        return Stream.of(
                Arguments.of(0, List.of(1, 0, 2)),
                Arguments.of(1, List.of(0, 2, 1))
        );
    }
}
