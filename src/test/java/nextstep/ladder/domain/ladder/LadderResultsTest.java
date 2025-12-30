package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderResultsTest {

    @Test
    void 사다리_결과목록_정상_생성() {
        LadderResults result = new LadderResults(
                new LadderResult(new User("pobi"), 0),
                new LadderResult(new User("honux"), 0),
                new LadderResult(new User("crong"), 0),
                new LadderResult(new User("jk"), 0)
        );

        assertThat(result.getResults()).hasSize(4);
    }


}
