package nextstep.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {

    @Test
    @DisplayName("LadderResult_생성_테스트")
    public void LadderResult_생성_테스트(){
        String[] result = {"꽝","5000","꽝","3000"};
        assertThat(new LadderResult(result)).isEqualTo(new LadderResult(result));
    }
}
