package ladder.domain;

import ladder.util.RandomStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(List<Boolean> input) {
        assertThat(new Line(input)).isEqualTo(new Line(input));
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(false, false, false)),
                Arguments.of(Arrays.asList(false, true, false)),
                Arguments.of(Arrays.asList(false, false, false, true))
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_createSource")
    void invalid_create(List<Boolean> input) {
        assertThatThrownBy(() -> new Line(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalid_createSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(true, false, false)),
                Arguments.of(Arrays.asList(true, false, true)),
                Arguments.of(Arrays.asList(false, true, true)),
                Arguments.of(Arrays.asList(true, false, false, false)),
                Arguments.of(Arrays.asList(true, false, true, false)),
                Arguments.of(Arrays.asList(true, false, false, true)),
                Arguments.of(Arrays.asList(false, true, true, false)),
                Arguments.of(Arrays.asList(false, false, true, true))
        );
    }
}
