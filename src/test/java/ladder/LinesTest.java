package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinesTest {

    @DisplayName("사다리 높이만큼 Line을 생성한다.")
    @Test
    void createLine() {
        // given
        int ladderHeight = 5;
        int numberOfParticipant = 4;

        // when
        Lines lines = new Lines(ladderHeight, numberOfParticipant);

        // then
        Assertions.assertThat(lines.getLineHeight()).isEqualTo(5);
    }
}