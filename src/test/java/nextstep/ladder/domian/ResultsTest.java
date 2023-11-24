package nextstep.ladder.domian;

import nextstep.ladder.domain.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    private Results result;

    @DisplayName("결과를 생성한다.")
    @Test
    void 결과를_생성한다() {
        result = new Results("꽝,5000,꽝,3000");
    }

    @DisplayName("결과는 참여자 수와 같아야 한다.")
    @Test
    void 결과는_참여자_수와_같아야_한다() {
        result = new Results("꽝,5000,꽝,3000");
        int size = 4;
        assertThat(result.validateSize(4)).isTrue();
    }
}
