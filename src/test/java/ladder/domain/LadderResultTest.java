package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderResultTest {
    private LadderResult ladderResult;

    @BeforeEach
    void setup() {
        ladderResult = new LadderResult();
        ladderResult.put(new Player("zeny"), new PlayResult("꽝"));
        ladderResult.put(new Player("zisu"), new PlayResult("5000원"));
        ladderResult.put(new Player("rose"), new PlayResult("10000원"));
    }

    @DisplayName("find")
    @Test
    void find() {
        PlayResult playResult = ladderResult.find(new Player("zeny"));
        assertThat(playResult).isEqualTo(new PlayResult("꽝"));
    }

    @DisplayName("LadderResult에 없는 player를 find 할 때 IllegalArgumentException 발생")
    @Test
    void find_ThrowsIllegalArgumentException_IfInputPlayerIsNotInvolvedPlayer() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> ladderResult.find(new Player("risa"))
        );
    }
}
