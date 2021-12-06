package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(List<Line> input) {
        assertThat(new Ladder(input)).isEqualTo(new Ladder(input));
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        new Line(Arrays.asList(false, false, false))
                )),
                Arguments.of(Arrays.asList(
                        new Line(Arrays.asList(false, true, false)),
                        new Line(Arrays.asList(false, true, false))
                )),
                Arguments.of(Arrays.asList(
                        new Line(Arrays.asList(false, false, true)),
                        new Line(Arrays.asList(false, false, true)),
                        new Line(Arrays.asList(false, false, true))
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_createSource")
    void invalid_create(List<Line> input) {
        assertThatThrownBy(() -> new Ladder(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalid_createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList())
        );
    }

    @ParameterizedTest
    @MethodSource("resultSource")
    @DisplayName("Ladder 는 LadderResult 를 반환할 수 있다.")
    void result(List<Line> input) {
        // given
        Map<Integer, Integer> value = new HashMap<>();
        value.put(3, 1);
        value.put(2, 0);
        value.put(1, 2);
        value.put(0, 3);

        // when
        Ladder ladder = new Ladder(input);

        // then
        assertThat(ladder.result()).isEqualTo(new LadderResult(value));
    }

    static Stream<Arguments> resultSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        new Line(Arrays.asList(false, false, true, false)),
                        new Line(Arrays.asList(false, true, false, true)),
                        new Line(Arrays.asList(false, false, true, false)),
                        new Line(Arrays.asList(false, false, false, true))
                ))
        );
    }
}