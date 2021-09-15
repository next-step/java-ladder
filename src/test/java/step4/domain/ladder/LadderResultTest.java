package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.user.User;
import step4.exception.ladder.LadderResultUserNotFoundException;

public class LadderResultTest {

    @Test
    @DisplayName("결과에 없는 유저를 반환하면 Exception이 발생해야 한다.")
    void testResultGetExceptionTest() {

        // given
        User user = User.of("pobi");
        Map<User, String> map = new HashMap<>();
        map.put(user, "5000");
        LadderResult result = LadderResult.of(map);
        User input = User.of("honux");

        // when && then
        assertThatExceptionOfType(LadderResultUserNotFoundException.class)
            .isThrownBy(() -> result.getResultByUser(input))
            .withMessageMatching("입력된 사람의 결과만 확인할 수 있다.");
    }

}
