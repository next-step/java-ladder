package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    @Test
    public void 라인리스트확인하기() {
        LadderResult ladderResult = new LadderResult();
        for(int i =0 ; i< 4 ; i++){
            ladderResult.addLine(new LadderLine(5, Mode.NORMAL));
        }
        assertThat(ladderResult.ofladder()).hasSize(4);
    }
}
