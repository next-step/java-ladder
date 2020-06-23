package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {

    @DisplayName("입력을 받아 사다리게임 결과 값이 정상적으로 생성된다.")
    @Test
    public void createTest() {
        LadderResult ladderResult = LadderResult.of("꽝");
        List<LadderResult> ladderResults = LadderResult.of(List.of("꽝", "10000"));

        assertThat(ladderResult.toString()).isEqualTo("꽝");

        assertThat(ladderResults.size()).isEqualTo(2);
        assertThat(ladderResults.get(0).toString()).isEqualTo("꽝");
        assertThat(ladderResults.get(1).toString()).isEqualTo("10000");
    }

}
