package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.UserName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderResultTest {

    @Test
    void 사다리_결과_정상_생성(){
        LadderResult result = new LadderResult(new User("pobi"));
        assertThat(result.getUser().getName()).isEqualTo(new UserName("pobi"));
    }


}
