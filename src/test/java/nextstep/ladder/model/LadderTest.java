package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("사다리의 높이 만큼 사다리가 생성이 되었는지 확인한다.")
    void confirmLadderHeight() {
        Ladder ladder = new Ladder(3, 5);
        assertThat(ladder.lines()).hasSize(3);
    }

}