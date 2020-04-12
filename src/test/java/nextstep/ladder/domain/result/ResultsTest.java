package nextstep.ladder.domain.result;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    @Test
    void of() {
        Results results = Results.of(Arrays.asList("꽝", "1000원", "2000원"));
        assertThat(results)
                .isEqualTo(Results.of(Arrays.asList("꽝", "1000원", "2000원")));
    }

    @Test
    void size() {
        Results results = Results.of(Arrays.asList("꽝", "1000원", "2000원"));
        assertThat(results.size())
                .isEqualTo(3);
    }

    @Test
    void getResult() {
        Results results = Results.of(Arrays.asList("꽝", "1000원", "2000원"));
        assertThat(results.getResult(2))
                .isEqualTo("2000원");
    }

    @Test
    void getResults() {
        Results results = Results.of(Arrays.asList("꽝", "1000원", "2000원"));
        assertThat(results.getResults())
                .containsExactly("꽝", "1000원", "2000원");
    }

}