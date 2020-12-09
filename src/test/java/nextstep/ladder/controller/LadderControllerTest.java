package nextstep.ladder.controller;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class LadderControllerTest {

    LadderController controller;

    @Test
    @DisplayName("결과 매치 테스트")
    void matchTest() {
        Map<User, Integer> endMap = new HashMap<>();
        endMap.put(User.of("java"), 0);
        endMap.put(User.of("study"), 1);
        endMap.put(User.of("game"), 2);

        Map<Result, Integer> resultMap = new HashMap<>();
        resultMap.put(Result.of("1000"), 0);
        resultMap.put(Result.of("2000"), 1);
        resultMap.put(Result.of("3000"), 2);

        controller = new LadderController();

        Map<User, Result> userResultMap = controller.matchResults(endMap, resultMap);

        Map<User, Result> answerMap = new HashMap<>();
        answerMap.put(User.of("java"), Result.of("1000"));
        answerMap.put(User.of("study"), Result.of("2000"));
        answerMap.put(User.of("game"), Result.of("3000"));

        Assertions.assertThat(userResultMap).isEqualTo(answerMap);

    }
}
