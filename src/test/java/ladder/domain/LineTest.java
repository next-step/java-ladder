package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("4명의 참가자가 있을경우 3개의 사다리 가로줄이 생성된다.")
    void createLine() {
        int totalMemberCount = 4;
        Line line = new Line(totalMemberCount, () -> true);

        assertThat(line.getPoints()).hasSize(3);
    }
}