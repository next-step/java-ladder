package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderPrizeTest {

    @DisplayName("입력을 받아 사다리게임 결과 값이 정상적으로 생성된다.")
    @Test
    public void createTest() {
        LadderPrize ladderPrize = LadderPrize.of("꽝");
        assertThat(ladderPrize.toString()).isEqualTo("꽝");
    }

}
