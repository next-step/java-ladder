package nextstep.ladder.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExecuteResultsTest {

    @Test
    @DisplayName("위치를 입력하면 해당값을 반환한다.")
    void test01() {
        ExecuteResults results = ExecuteResults.of("a,b,c");
        Assertions.assertThat(results.getResult(0)).isEqualTo(new Result("a"));
    }

}
