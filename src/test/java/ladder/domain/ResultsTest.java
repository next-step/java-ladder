package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @Test
    void 실행결과생성() {
        assertThat(Results.of("꽝,5000,꽝,3000").countOfResult()).isEqualTo(4);
    }
}
