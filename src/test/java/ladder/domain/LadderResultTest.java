package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultTest {


    static Stream<Arguments> generateResult() {
        return Stream.of(
                Arguments.of(Map.of(1, "곱창", 2, "떡볶이")),
                Arguments.of(Map.of(1, "제로콜라", 2, "곱창", 3, "피자"))
        );
    }

    @Test
    void shouldValidateEachResult() {
        assertThatThrownBy(() -> new LadderResult(Arrays.asList("꽝", "당첨", null), 3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LadderResult(Arrays.asList("꽝", "당첨", ""), 3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldValidateSizeOfResult() {
        assertThatThrownBy(() -> new LadderResult(Arrays.asList("꽝", "당첨", "당첨"), 2)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("generateResult")
    void shouldGetGameResult(Map<Integer, String> inputs) {
        LadderResult ladderResult = new LadderResult();
        inputs.entrySet()
                .forEach((entry) -> {
                    Position position = new Position(entry.getKey());
                    Result result = new Result(entry.getValue());
                    ladderResult.add(position, result);
                    assertThat(ladderResult.findResultByPosition(position)).isEqualTo(result);
                });
    }

}
