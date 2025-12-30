package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LadderResultsTest {

    @Test
    void 사다리_결과목록_정상_생성() {
        LadderResults result = new LadderResults(
                new LadderResult(new User("pobi")),
                new LadderResult(new User("honux")),
                new LadderResult(new User("crong")),
                new LadderResult(new User("jk"))
        );

        assertThat(result.getResults()).hasSize(4);
    }


}
