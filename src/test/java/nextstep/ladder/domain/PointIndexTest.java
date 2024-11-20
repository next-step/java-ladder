package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PointIndexTest {

    @ParameterizedTest
    @MethodSource("swapResult")
    void left의_바로다음숫자와_값을_스왑한다(int left, Map<Integer, Integer> result) {
        PointIndex pointIndex = new PointIndex(left);
        HashMap<Integer, Integer> before = new HashMap<>(Map.of(0, 0, 1, 1, 2, 2));

        pointIndex.swap(before);

        assertThat(before).isEqualTo(result);

    }

    private static Stream<Arguments> swapResult() {
        return Stream.of(
                Arguments.of(0, Map.of(0, 1, 1, 0, 2, 2)),
                Arguments.of(1, Map.of(0, 0, 1, 2, 2, 1))
        );
    }
}
