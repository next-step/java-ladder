package ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @ParameterizedTest
    @MethodSource("autoCreateSource")
    void autoCreate(int input, List<Line> cases) {
        assertThat(cases).contains(new Line(input));
    }

    static Stream<Arguments> autoCreateSource() {
        return Stream.of(
                Arguments.of(3, Arrays.asList(
                        new Line(Arrays.asList(false, false, false)),
                        new Line(Arrays.asList(false, true, false)),
                        new Line(Arrays.asList(false, false, true))
                )),
                Arguments.of(4, Arrays.asList(
                        new Line(Arrays.asList(false, false, false, false)),
                        new Line(Arrays.asList(false, true, false, false)),
                        new Line(Arrays.asList(false, false, true, false)),
                        new Line(Arrays.asList(false, false, false, true)),
                        new Line(Arrays.asList(false, true, false, true))
                ))
        );
    }

    @ParameterizedTest
    @MethodSource("manualCreateSource")
    void manualCreate(List<Boolean> input) {
        assertThat(new Line(input)).isEqualTo(new Line(input));
    }

    static Stream<Arguments> manualCreateSource() {
        return Stream.of(
                Arguments.of(Arrays.asList(false, false, false)),
                Arguments.of(Arrays.asList(false, true, false)),
                Arguments.of(Arrays.asList(false, false, true)),
                Arguments.of(Arrays.asList(false, false, false, false)),
                Arguments.of(Arrays.asList(false, true, false, false)),
                Arguments.of(Arrays.asList(false, false, true, false)),
                Arguments.of(Arrays.asList(false, false, false, true)),
                Arguments.of(Arrays.asList(false, true, false, true))
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_manualCreateSource")
    void invalid_manualCreate(List<Boolean> input) {
        assertThatThrownBy(() -> new Line(input));
    }

    static Stream<Arguments> invalid_manualCreateSource() {
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
