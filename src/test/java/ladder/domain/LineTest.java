package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("4명의 참가자가 있을경우 3개의 사다리 가로줄이 생성된다.")
    void createLine() {
        int totalMemberCount = 4;
        Line line = Line.createLine(totalMemberCount, () -> true);

        assertThat(line.getPoints()).hasSize(3);
    }

    @ParameterizedTest(name = "2명의 참가자가 있을경우(true,false) {0}번째 사람은 {1}쪽으로 움직인다.")
    @CsvSource(value = {"0, RIGHT", "1, LEFT"})
    void canMoveRight(int userIndex, Direction expected) {
        int totalMemberCount = 2;
        Line line = Line.createLine(totalMemberCount, () -> true);

        assertThat(line.move(userIndex)).isEqualTo(expected);
    }
}
