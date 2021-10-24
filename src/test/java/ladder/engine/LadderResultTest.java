package ladder.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    @DisplayName("처음 포지션을 넣으면 결과 포지션이 output으로 나오는지 확인")
    void put() {
        LadderResult ladderResult = new LadderResult();
        ladderResult.put(3, 1);
        assertThat(ladderResult.getTarget(3)).isEqualTo(1);
    }
}
