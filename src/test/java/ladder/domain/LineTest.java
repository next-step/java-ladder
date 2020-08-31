package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private static Stream<Arguments> makeLineCreateData() {
        return Stream.of(
                Arguments.of("p1,p2", false, new LineRepeatGenerator(true)),
                Arguments.of("p1,p2,p3", false, new LineRepeatGenerator(false)),
                Arguments.of("p1,p2,p3,p4", false, new LineRandomGenerator()),
                Arguments.of("p1,p2,p3,p4,p5,p6,p7", false, new LineRandomGenerator()),
                Arguments.of("p1,p2,p3,p4", false, new LineFixGenerator(true))
        );
    }

    @DisplayName("Line 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeLineCreateData")
    void create(String participantNames, boolean expectedResult, LineGenerator lineGenerator) {
        Participants participants = Participants.from(participantNames);
        Line line = Line.create(participants, lineGenerator);
        List<Point> points = line.getPoints();

        boolean actual = points.subList(1, points.size() - 1)
                .stream()
                .anyMatch(point -> point.isRight() && point.isLeft());

        // 참가자 수 만큼 생성되었는지 확인
        assertThat(line.getSize()).isEqualTo(participants.getNumber());
        // 연속되지 않게 생성되었는지 확인
        assertThat(actual).isEqualTo(expectedResult);
    }

    @DisplayName("Line 특정 인덱스를 기준으로 다음 인덱스 계산 테스트")
    @ParameterizedTest
    @MethodSource("makeCalculateNextIndexData")
    void calculateNextIndex(String expectedParticipantNumber, boolean lineGeneratorOrder, List<Integer> expectedResult) {
        Participants participants = Participants.from(expectedParticipantNumber);
        Line line = Line.create(participants, new LineRepeatGenerator(lineGeneratorOrder));

        for (int index = 0; index < expectedResult.size(); index++) {
            int actualNextIndex = line.calculateNextIndex(index);
            int expectedNextIndex = expectedResult.get(index);

            assertThat(actualNextIndex).isEqualTo(expectedNextIndex);
        }
    }

    private static Stream<Arguments> makeCalculateNextIndexData() {
        return Stream.of(
                Arguments.of("p1,p2,p3,p4", true, Arrays.asList(0, 2, 1, 3)),
                Arguments.of("p1,p2,p3,p4,p5", false, Arrays.asList(1, 0, 3, 2, 4))
        );
    }
}
