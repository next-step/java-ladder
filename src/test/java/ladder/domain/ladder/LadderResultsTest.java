package ladder.domain.ladder;

import static ladder.domain.ladder.Point.createNextByBeforePoint;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    @Test
    @DisplayName("실행 결과를 받아 저장할 수 있다.")
    void ladderResultsSaveTest() {

        // given
        String input = "꽝,5000,꽝,3000";
        int userCount = 4;
        LadderResults expected = new LadderResults(Arrays.asList("꽝", "5000", "꽝", "3000"));

        // when
        LadderResults results =  LadderResults.from(input, 4);

        // then
        assertThat(results).isEqualTo(expected);
    }

    @Test
    @DisplayName("실행 결과가 사람수와 일치하지 않으면 exception이 발생되어야 한다.")
    void ladderResultSaveFailTest() {

        // given
        String input = "꽝,5000,꽝,3000";
        int userCount = 5;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> LadderResults.from(input, userCount))
            .withMessageMatching("사람 수와 동일한 수의 결과가 입력되어야 한다.");
    }

}