package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void 생성() {
        LadderResult ladderResult = new LadderResult(new String[] {"꽝", "5000", "꽝", "3000"});

        assertThat(ladderResult).isEqualTo(new LadderResult(new String[] {"꽝", "5000", "꽝", "3000"}));
    }

    @Test
    void 플레이어_수와_같은지_확인한다() {
        int playerSize = 3;
        LadderResult ladderResult = new LadderResult(new String[] {"꽝", "5000", "꽝", "3000"});

        assertThatThrownBy(() -> ladderResult.validSize(playerSize))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
