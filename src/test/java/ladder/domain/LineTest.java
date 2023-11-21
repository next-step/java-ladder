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

    @ParameterizedTest(name = "2명의 참가자가 있을경우(true,false) {0}번째 사람은 오른쪽으로 이동할 수 있다. {1}")
    @CsvSource(value = {"0, true", "1, false"})
    void canMoveRight(int userIndex, boolean expected) {
        int totalMemberCount = 2;
        Line line = Line.createLine(totalMemberCount, () -> true);

        assertThat(line.canMoveRight(userIndex)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "3명의 참가자가 있을경우(true,false) {0}번째 사람은 오른쪽으로 이동할 수 있다. {1}")
    @CsvSource(value = {"0, false", "1, true", "2, false"})
    void canMoveLeft(int userIndex, boolean expected) {
        int totalMemberCount = 3;
        Line line = Line.createLine(totalMemberCount, () -> true);

        assertThat(line.canMoveLeft(userIndex)).isEqualTo(expected);
    }
}