package domain;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    static Stream<Arguments> ladderTworParticipantAndOneLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero")),
                        1,
                        (LineGenerator) i -> new Line(new ArrayList<>(Arrays.asList(false))),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false)))
                        ))
                ),
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero")),
                        1,
                        (LineGenerator) i -> new Line(new ArrayList<>(Arrays.asList(true))),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(true)))
                        ))
                )
        );
    }

    @DisplayName("Ladder: 참여자 2명, line 1개 케이스")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {3}")
    @MethodSource("ladderTworParticipantAndOneLineParam")
    void ladderTworParticipantAndOneLine(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(participantNames, ladderHeight, lineGenerator);
        List<Line> lines = ladder.getLines();
        assertThat(lines).isEqualTo(expectedLines);
    }

    static Stream<Arguments> ladderTworParticipantAndThreeLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero")),
                        3,
                        (LineGenerator) i -> new Line(new ArrayList<>(Arrays.asList(false))),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false))),
                                new Line(new ArrayList<>(Arrays.asList(false))),
                                new Line(new ArrayList<>(Arrays.asList(false)))
                        ))
                ),
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero")),
                        3,
                        (LineGenerator) i -> new Line(new ArrayList<>(Arrays.asList(true))),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(true))),
                                new Line(new ArrayList<>(Arrays.asList(true))),
                                new Line(new ArrayList<>(Arrays.asList(true)))
                        ))
                )
        );
    }

    @DisplayName("Ladder: 참여자 2명, line 3개 케이스")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {3}")
    @MethodSource("ladderTworParticipantAndThreeLineParam")
    void ladderTworParticipantAndThreeLine(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(participantNames, ladderHeight, lineGenerator);
        List<Line> lines = ladder.getLines();
        assertThat(lines).isEqualTo(expectedLines);
    }

    static Stream<Arguments> ladderFiveParticipantAndOneLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero", "1234567890", "1", "2")),
                        1,
                        (LineGenerator) i -> new Line(new ArrayList<>(Arrays.asList(false, false, false, false))),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false, false, false, false)))
                        ))
                ),
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero", "1234567890", "1", "2")),
                        1,
                        (LineGenerator) i -> new Line(new ArrayList<>(Arrays.asList(true, false, true, false))),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(true, false, true, false)))
                        ))
                )
        );
    }

    @DisplayName("Ladder: 참여자 5명, line 1개 케이스")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {3}")
    @MethodSource("ladderFiveParticipantAndOneLineParam")
    void ladderFiveParticipantAndOneLine(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(participantNames, ladderHeight, lineGenerator);
        List<Line> lines = ladder.getLines();
        assertThat(lines).isEqualTo(expectedLines);
    }

    static Stream<Arguments> ladderFiveParticipantAndThreeLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero", "1234567890", "1", "2")),
                        3,
                        (LineGenerator) i -> new Line(new ArrayList<>(Arrays.asList(false, false, false, false))),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false, false, false, false))),
                                new Line(new ArrayList<>(Arrays.asList(false, false, false, false))),
                                new Line(new ArrayList<>(Arrays.asList(false, false, false, false)))
                        ))
                ),
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero", "1234567890", "1", "2")),
                        3,
                        (LineGenerator) i -> new Line(new ArrayList<>(Arrays.asList(true, false, true, false))),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(true, false, true, false))),
                                new Line(new ArrayList<>(Arrays.asList(true, false, true, false))),
                                new Line(new ArrayList<>(Arrays.asList(true, false, true, false)))
                        ))
                )
        );
    }


    @DisplayName("Ladder: 참여자 5명, line 3개 케이스")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {3}")
    @MethodSource("ladderFiveParticipantAndThreeLineParam")
    void ladderFiveParticipantAndThreeLine(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(participantNames, ladderHeight, lineGenerator);
        List<Line> lines = ladder.getLines();
        assertThat(lines).isEqualTo(expectedLines);
    }
}
