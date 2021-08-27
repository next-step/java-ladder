package nextstep.step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderResultTest {

    @Test
    public void ladderResultPut() {
        LadderResult ladderResult = LadderResult.of();
        ladderResult.put(0, 1);
        assertThat(ladderResult.getEndPoint(0)).isEqualTo(1);

    }


}
