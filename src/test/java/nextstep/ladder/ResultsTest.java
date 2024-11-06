package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    private Results results;

    @BeforeEach
    void setUp() {
        results = new Results(Arrays.asList(new Result(new Username("TEST"), "꽝"), new Result(new Username("TEST2"), "5000"), new Result(new Username("TEST3"), "10000")));
    }

    @Test
    void 사용자_이름으로_결과_조회() {
        assertThat(results.getResultByUsername("TEST")).isEqualTo("꽝");
    }

    @Test
    void 사용자_이름으로_결과_조회__all() {
        assertThat(results.getResultByUsername("all")).hasSize(results.getSize());
    }
}
