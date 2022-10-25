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

public class LadderTest {
    static Stream<Arguments> ladderTwoParticipantAndOneLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero")),
                        1,
                        (LineGenerator) i -> new Line(Arrays.asList(true)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(true)))
                        ))
                ),
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero")),
                        1,
                        (LineGenerator) i -> new Line(Arrays.asList(false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(Arrays.asList(false)))
                        ))
                )
        );
    }

    @DisplayName("Ladder: 참여자 2명, 높이가 1인 케이스")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {3}")
    @MethodSource("ladderTwoParticipantAndOneLineParam")
    void ladderTwoParticipantAndOneLine(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(participantNames, ladderHeight, lineGenerator);
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < lines.size(); i++) {
            assertThat(expectedLines.get(i).getLine()).isEqualTo(lines.get(i).getLine());
        }
    }

    static Stream<Arguments> ladderTwoParticipantAndThreeLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero")),
                        3,
                        (LineGenerator) i -> new Line(List.of(false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(List.of(false))),
                                new Line(new ArrayList<>(List.of(false))),
                                new Line(new ArrayList<>(List.of(false)))
                        ))
                ),
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero")),
                        3,
                        (LineGenerator) i -> new Line(Arrays.asList(true)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(List.of(true))),
                                new Line(new ArrayList<>(List.of(true))),
                                new Line(new ArrayList<>(List.of(true)))
                        ))
                )
        );
    }

    @DisplayName("Ladder: 참여자 2명, 높이가 3인 케이스")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {3}")
    @MethodSource("ladderTwoParticipantAndThreeLineParam")
    void ladderTwoParticipantAndThreeLine(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(participantNames, ladderHeight, lineGenerator);
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < lines.size(); i++) {
            assertThat(expectedLines.get(i).getLine()).isEqualTo(lines.get(i).getLine());
        }
    }

    static Stream<Arguments> ladderFiveParticipantAndOneLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero", "1234567890", "1", "2")),
                        1,
                        (LineGenerator) i -> new Line(Arrays.asList(false, false, false, false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(List.of(false, false, false, false)))
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

    @DisplayName("Ladder: 참여자 5명, 높이 1인 케이스")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {3}")
    @MethodSource("ladderFiveParticipantAndOneLineParam")
    void ladderFiveParticipantAndOneLine(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(participantNames, ladderHeight, lineGenerator);
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < lines.size(); i++) {
            assertThat(expectedLines.get(i).getLine()).isEqualTo(lines.get(i).getLine());
        }
    }

    static Stream<Arguments> ladderFiveParticipantAndThreeLineParam() {
        return Stream.of(
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero", "1234567890", "1", "2")),
                        3,
                        (LineGenerator) i -> new Line(Arrays.asList(false, false, false, false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(List.of(false, false, false, false))),
                                new Line(new ArrayList<>(List.of(false, false, false, false))),
                                new Line(new ArrayList<>(List.of(false, false, false, false)))
                        ))
                ),
                Arguments.arguments(
                        new ArrayList<>(Arrays.asList("kero", "zero", "1234567890", "1", "2")),
                        3,
                        (LineGenerator) i -> new Line(Arrays.asList(true, false, true, false)),
                        new ArrayList<>(Arrays.asList(
                                new Line(new ArrayList<>(List.of(true, false, true, false))),
                                new Line(new ArrayList<>(List.of(true, false, true, false))),
                                new Line(new ArrayList<>(List.of(true, false, true, false)))
                        ))
                )
        );
    }


    @DisplayName("Ladder: 참여자 5명, 높이가 3인 케이스")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {3}")
    @MethodSource("ladderFiveParticipantAndThreeLineParam")
    void ladderFiveParticipantAndThreeLine(List<String> participantNames, int ladderHeight, LineGenerator lineGenerator, List<Line> expectedLines) {
        Ladder ladder = new Ladder(participantNames, ladderHeight, lineGenerator);
        List<Line> lines = ladder.getLines();
        for (int i = 0; i < lines.size(); i++) {
            assertThat(expectedLines.get(i).getLine()).isEqualTo(lines.get(i).getLine());
        }
    }


    static Stream<Arguments> getNamesMaxLengthParam() {
        return Stream.of(
                Arguments.arguments(
                        new Ladder(
                                new ArrayList<>(Arrays.asList("a", "b")),
                                3,
                                i -> new Line(Arrays.asList(false, false, false, false))
                        ),
                        1
                ),
                Arguments.arguments(
                        new Ladder(
                                new ArrayList<>(Arrays.asList("a", "aaaa")),
                                3,
                                i -> new Line(Arrays.asList(false, false, false, false))
                        ),
                        4
                ),
                Arguments.arguments(
                        new Ladder(
                                new ArrayList<>(Arrays.asList("aaaa", "a")),
                                3,
                                i -> new Line(Arrays.asList(false, false, false, false))
                        ),
                        4
                ),
                Arguments.arguments(
                        new Ladder(
                                new ArrayList<>(Arrays.asList("1", "1234567890", "2")),
                                3,
                                i -> new Line(Arrays.asList(false, false, false, false))
                        ),
                        10
                )
        );
    }


    @DisplayName("참여자 이름중 가장긴 이름의 길이 반환")
    @ParameterizedTest(name = "{displayName} {index} expectedLines: {0}")
    @MethodSource("getNamesMaxLengthParam")
    void getNamesMaxLength(Ladder ladder, int expectedLength) {
        assertThat(ladder.getNamesMaxLength()).isEqualTo(expectedLength);
    }
}
