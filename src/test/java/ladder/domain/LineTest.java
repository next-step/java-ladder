package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    private static Stream<Arguments> makeLineCreateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(new Points()), 1),
                Arguments.of(Arrays.asList(new Points(), new Points(), new Points()), 3),
                Arguments.of(Arrays.asList(new Points(), new Points(), new Points(), new Points(), new Points()), 5)
        );
    }

    @DisplayName("Line 생성 테스트")
    @ParameterizedTest
    @MethodSource("makeLineCreateData")
    void create(List<Points> points, int participantNumber) {
        Line line = Line.create(points);

        boolean actual = line.stream()
                .anyMatch(point -> point.isRight() == point.isLeft());

        // 참가자 수 만큼 생성되었는지 확인
        assertThat(line.getSize()).isEqualTo(participantNumber);
        // 연속되지 않게 생성되었는지 확인
        assertThat(actual).isFalse();
    }
}
