package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.user.Users;
import step4.exception.ladder.LadderEndPointCountException;

class LadderEndPointsTest {

    @Test
    @DisplayName("endpoint에서 사람 수와 일치하지 않으면 Exception이 발생해야 한다.")
    void createLadderEndPointFailTest() {

        // given
        String input = "꽝,5000,꽝,3000";
        Users users = Users.of("pobi,honux,crong");

        // when & then
        assertThatExceptionOfType(LadderEndPointCountException.class)
            .isThrownBy(() -> LadderEndPoints.from(input, users))
            .withMessageMatching("사람 수와 동일한 수의 결과가 입력되어야 한다.");
    }

}