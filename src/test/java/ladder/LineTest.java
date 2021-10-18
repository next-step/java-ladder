package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("참가자 수 만큼 사디리(좌표(point))가 생긴다.")
    @Test
    void createPoint() {
        // given
        int numberOfParticipant = 4;

        // when
        Line line = new Line(numberOfParticipant);

        // then
        assertThat(line.getPointsSize()).isEqualTo(numberOfParticipant);
    }
}