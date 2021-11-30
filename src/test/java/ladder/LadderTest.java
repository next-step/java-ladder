package ladder;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @ParameterizedTest
    @MethodSource("createSource")
    void create(int width, int height, List<Line> cases) {
        new Ladder(width, height).getLines()
                .stream()
                .forEach(line -> assertThat(cases).contains(line));
    }

    static Stream<Arguments> createSource() {
        return Stream.of(
                Arguments.of(3, 5, Arrays.asList(
                        new Line(Arrays.asList(false, false, false)),
                        new Line(Arrays.asList(false, true, false)),
                        new Line(Arrays.asList(false, false, true))
                )),
                Arguments.of(4, 5, Arrays.asList(
                        new Line(Arrays.asList(false, false, false, false)),
                        new Line(Arrays.asList(false, true, false, false)),
                        new Line(Arrays.asList(false, false, true, false)),
                        new Line(Arrays.asList(false, false, false, true)),
                        new Line(Arrays.asList(false, true, false, true))
                ))
        );
    }
}