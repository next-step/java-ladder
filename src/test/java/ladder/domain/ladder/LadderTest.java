package ladder.domain.ladder;

import ladder.domain.util.RightPointRandom;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void getSize() {
        Ladder ladder = new Ladder(5, 3, new RightPointRandom());
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사다리게임 시작 메소드, () -> false로 생성시 사다리는 직선으로 구성")
    void getResultIndexByPlayerIndex() {
        Ladder ladder = new Ladder(5, 3, () -> false);
        Assertions.assertThat(ladder.getResultIndexByPlayerIndex(0))
                .isEqualTo(0);
    }
}