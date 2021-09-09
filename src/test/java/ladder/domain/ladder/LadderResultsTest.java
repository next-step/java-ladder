package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    @Test
    @DisplayName("end point를 받아 저장할 수 있다.")
    void ladderEndPointsSaveTest() {

        // given
        String input = "꽝,5000,꽝,3000";
        int userCount = 4;
        LadderEndPoints expected = new LadderEndPoints(Arrays.asList("꽝", "5000", "꽝", "3000"));

        // when
        LadderEndPoints results =  LadderEndPoints.from(input, 4);

        // then
        assertThat(results).isEqualTo(expected);
    }

    @Test
    @DisplayName("end point가 사람수와 일치하지 않으면 exception이 발생되어야 한다.")
    void ladderEndPointsSaveFailTest() {

        // given
        String input = "꽝,5000,꽝,3000";
        int userCount = 5;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LadderEndPoints.from(input, userCount))
            .withMessageMatching("사람 수와 동일한 수의 결과가 입력되어야 한다.");
    }

}