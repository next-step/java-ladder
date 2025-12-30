package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {

    @Test
    void 사다리_결과_정상_생성(){
        LadderResult result = new LadderResult(new User("pobi", 0), 0);
        assertThat(result.getPosition()).isEqualTo(0);
    }

    @Test
    void 사다리_위치_변경(){
        LadderResult result = new LadderResult(new User("pobi", 0), 0);
        result.plusPosition();
        assertThat(result.getPosition()).isEqualTo(1);
        result.minusPosition();
        assertThat(result.getPosition()).isEqualTo(0);
    }


}
