package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @Test
    @DisplayName("0번 결과 출력")
    void test1() {
        // given
        String success = "2000";
        Results results = new Results(success, "꽝", "꽝", "꽝");
        // when
        Result result = results.findResultOf(0);
        // then
        assertThat(result).isEqualTo(new Result(success));
    }

}
