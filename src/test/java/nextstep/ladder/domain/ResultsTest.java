package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    @DisplayName("getResultNames 테스트 | {arguments}")
    public void getResultNames() {
        // given
        Results results = new Results("꽝,5000,꽝,3000");

        // when
        List<String> resultNames = results.getResultNames();

        // then
        assertThat(resultNames).containsExactly("꽝", "5000", "꽝", "3000");
    }

}