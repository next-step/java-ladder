package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    @DisplayName("주어진 height 만큼의 row를 생성한다.")
    void 사다리_생성() {
        Ladder ladder = new Ladder(3, 3);
        assertThat(ladder.size()).isEqualTo(3);
    }
}
