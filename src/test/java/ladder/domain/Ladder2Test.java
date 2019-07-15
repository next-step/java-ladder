package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Ladder2Test {
    int height = 4;
    int ladderSize = 4;

    @Test
    @DisplayName("Ladder 를 주어진 크기와 높이만큼 생성한다")
    void constructor() {
        Ladder2 ladder2 = Ladder2.of(height, ladderSize);
        assertThat(ladder2.height()).isEqualTo(height);
    }
}
