package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    @DisplayName("주어진 너비와 높이 만큼 사다리를 생성한다")
    void name() {
        int width = 4;
        int height = 4;
        LadderSize ladderSize = new LadderSize(width, height);

        Ladder ladder = Ladder.generate(ladderSize, () -> true);

        Assertions.assertThat(ladder.size()).isEqualTo(height);
    }
}