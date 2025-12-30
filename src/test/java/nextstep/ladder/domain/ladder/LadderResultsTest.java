package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderResultsTest {

    @Test
    void 사다리_결과목록_정상_생성() {
        LadderResults result = new LadderResults(
                new LadderResult(new User("pobi", 0), 0),
                new LadderResult(new User("honux", 1), 0),
                new LadderResult(new User("crong", 2), 0),
                new LadderResult(new User("jk", 3), 0)
        );

        assertThat(result.getResults()).hasSize(4);
    }


}
