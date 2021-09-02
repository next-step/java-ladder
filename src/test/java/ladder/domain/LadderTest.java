package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리는 높이를 받아 저장할 수 있다.")
    void ladderCreateTest() {

        // given
        int input = 5;

        // when
        Ladder ladder = new Ladder(input);

        // then
        assertThat(ladder).isNotNull();
    }

}