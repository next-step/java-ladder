package nextstep.ladder.ladder;

import nextstep.ladder.entity.ladder.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {
    @Test
    @DisplayName("사다리 게임 결과 생성")
    public void ladderResultCreate(){
        String result = "5000";

        LadderResult ladderResult = new LadderResult(result);

        assertThat(ladderResult.equals(new LadderResult(result))).isTrue();
    }
}
