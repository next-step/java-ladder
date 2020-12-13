package nextstep.step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void initLadder() {
        int numberOfUsers = 3;
        int height = 5;
        Ladder ladder = Ladder.init(3, 5);
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(height);
        Assertions.assertThat(ladder.getLines().get(0).getIndexList().size()).isEqualTo(numberOfUsers);
    }

}