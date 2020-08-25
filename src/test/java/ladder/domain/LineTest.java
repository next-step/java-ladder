package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("Line 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5"})
    void create(int participantCount) {
        Line line = Line.create(participantCount);

        boolean actual = line.stream()
                .anyMatch(points -> points.isRight() == points.isLeft());

        // 참가자 수 만큼 생성되었는지 확인
        assertThat(line.getSize()).isEqualTo(participantCount);
        // 연속되지 않게 생성되었는지 확인
        assertThat(actual).isFalse();
    }
}
