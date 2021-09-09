package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import ladder.domain.user.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    @DisplayName("현재 사람에 대한 결과를 반환할 수 있다.")
    void getNowUserResultTest() {

        // given
        Map<User, String> results = new HashMap<>();
        User user1 = new User("pobi");
        User user2 = new User("honux");
        results.put(user1, "꽝");
        results.put(user2, "5000");
        LadderResult ladderResult = new LadderResult(results);

        // when
        String result = ladderResult.getResultByUser(user1);

        // then
        assertThat(result).isEqualTo("꽝");
    }

}