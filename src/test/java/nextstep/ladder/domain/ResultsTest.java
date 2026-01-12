package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultsTest {
    @Test
    void 생성() {
        Results results = new Results("꽝,3000,꽝,5000");

        Assertions.assertThat(results.getResults()).hasSize(4);
    }
}
