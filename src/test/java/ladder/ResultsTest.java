package ladder;

import ladder.domain.Result;
import ladder.domain.Results;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    private Results results;

    @BeforeEach
    void setUp() {
        results = new Results("꽝,5000,꽝,3000");
    }

    @Test
    @DisplayName("경품_이름_포함")
    void resultContainsResultObject() {
        assertThat(results.getResults()).contains(new Result("꽝", 0), new Result("3000", 3));
    }
}
