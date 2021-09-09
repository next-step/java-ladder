package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.HashMap;
import java.util.Map;
import ladder.domain.user.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    private static Map<User, String> results;

    private static User pobi;
    private static User honux;

    @BeforeAll
    static void beforeAll() {
        results = new HashMap<>();
        User pobi = new User("pobi");
        User honux = new User("honux");
        results.put(pobi, "꽝");
        results.put(honux, "5000");
    }

    @Test
    @DisplayName("현재 사람에 대한 결과를 반환할 수 있다.")
    void getNowUserResultTest() {

        // given
        LadderResult ladderResult = new LadderResult(results);

        // when
        String result = ladderResult.getResultByUser(pobi);

        // then
        assertThat(result).isEqualTo("꽝");
    }

    @Test
    @DisplayName("없는 사람의 결과를 요청받으면 Exception이 발생되어야 한다.")
    void failByNoneUserTest() {

        // given
        User user = new User("test");
        LadderResult ladderResult = new LadderResult(results);

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ladderResult.getResultByUser(user))
            .withMessageMatching("입력된 사람의 결과만 확인할 수 있다.");
    }

}