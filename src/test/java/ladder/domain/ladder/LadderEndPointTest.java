package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import ladder.domain.user.Users;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderEndPointTest {

    @Test
    @DisplayName("end point를 받아 저장할 수 있다.")
    void ladderEndPointsSaveTest() {

        // given
        String input = "꽝,5000,꽝,3000";
        LadderEndPoints expected = new LadderEndPoints(Arrays.asList("꽝", "5000", "꽝", "3000"));
        Users users = Users.of("pobi,honux,crong,jk");

        // when
        LadderEndPoints results =  LadderEndPoints.from(input, users);

        // then
        assertThat(results).isEqualTo(expected);
    }

    @Test
    @DisplayName("end point가 사람수와 일치하지 않으면 exception이 발생되어야 한다.")
    void ladderEndPointsSaveFailTest() {

        // given
        String input = "꽝,5000,꽝";
        Users users = Users.of("pobi,honux,crong,jk");

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LadderEndPoints.from(input, users))
            .withMessageMatching("사람 수와 동일한 수의 결과가 입력되어야 한다.");
    }

}