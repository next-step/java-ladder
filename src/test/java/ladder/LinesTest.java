package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    void 사다리_높이만큼_사다리_생성() {
        // given
        int ladderHeight = 5;
        int numberOfParticipant = 4;

        // when
        Lines lines = new Lines(ladderHeight, numberOfParticipant);

        // then
        Assertions.assertThat(lines.getLineHeight()).isEqualTo(5);
    }
}