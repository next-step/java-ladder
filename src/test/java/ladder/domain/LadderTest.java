package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    static Stream<Arguments> LadderParam() {
        return Stream.of(
                Arguments.arguments(
                        1,
                        1,
                        (LineGenerator) i -> new Line(Arrays.asList(true)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(true)))
                        ))
                ),
                Arguments.arguments(
                        1,
                        1,
                        (LineGenerator) i -> new Line(Arrays.asList(false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false)))
                        ))
                ),
                Arguments.arguments(
                        1,
                        5,
                        (LineGenerator) i -> new Line(Arrays.asList(false, true, false, false, false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false, true, false, false, false)))
                        ))
                ),
                Arguments.arguments(
                        5,
                        1,
                        (LineGenerator) i -> new Line(Arrays.asList(false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false))),
                                new Line(new ArrayList<>(Arrays.asList(false))),
                                new Line(new ArrayList<>(Arrays.asList(false))),
                                new Line(new ArrayList<>(Arrays.asList(false))),
                                new Line(new ArrayList<>(Arrays.asList(false)))
                        ))
                ),
                Arguments.arguments(
                        2,
                        3,
                        (LineGenerator) i -> new Line(Arrays.asList(false, true, false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false, true, false))),
                                new Line(new ArrayList<>(Arrays.asList(false, true, false)))
                        ))
                )
        );
    }

    @DisplayName("Ladder생성 성공")
    @ParameterizedTest(name = "{displayName} {index}")
    @MethodSource("LadderParam")
    void Ladder(int height, int length, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(height, length, lineGenerator);
        List<Line> lines = ladder.ladder();
        assertThat(lines).isEqualTo(expectedLines);
    }
}