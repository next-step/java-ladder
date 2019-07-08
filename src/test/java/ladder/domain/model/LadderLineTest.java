package ladder.domain.model;

import ladder.RandomTestUtils;
import ladder.common.PositiveNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LadderLineTest {

    @Test
    @DisplayName("랜덤조건이 무조건 true인경우, 사다리 생성을 확인한다")
    void createLadder() {
        LadderLine ladderLine = LadderLine.of(RandomTestUtils.TRUE, PositiveNumber.of(5));
        assertThat(ladderLine.get().size()).isEqualTo(5);
        assertFalse(ladderLine.get().get(0).isLeft());
        assertTrue(ladderLine.get().get(0).isRight());
        assertTrue(ladderLine.get().get(1).isLeft());
        assertFalse(ladderLine.get().get(1).isRight());
        assertFalse(ladderLine.get().get(2).isLeft());
        assertTrue(ladderLine.get().get(2).isRight());
        assertTrue(ladderLine.get().get(3).isLeft());
        assertFalse(ladderLine.get().get(3).isRight());
        assertFalse(ladderLine.get().get(4).isLeft());
        assertFalse(ladderLine.get().get(4).isRight());
    }
}
