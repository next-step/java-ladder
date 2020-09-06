package nextstep.ladder.domain;

import nextstep.ladder.domain.result.LadderResult;
import nextstep.ladder.domain.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    private LadderResult ladderResult;
    private List<String> results;

    @BeforeEach
    void setUp() {
        List<User> users = Arrays.asList(new User("pobi"), new User("honux"));
        ladderResult = new LadderResult(users);
        results = Arrays.asList("당첨", "꽝");
    }

    @Test
    @DisplayName("사용자와 당첨결과 매핑")
    void matchUserAndLadderResult() {
        String result = LadderResult.maybeUserResult("pobi", ladderResult.getLadderResult(), results);
        assertThat(result).isEqualTo("당첨");
    }
}
