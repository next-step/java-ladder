package nextstep.ladder.domain.generator;

import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.generator.Results;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    private Results results;

    @BeforeEach
    void setUp() {
        results = Results.from(new String[] {"꽝", "5000", "꽝", "3000"});
    }

    @Test
    void results() {
        List<Result> originResult = results.getResults();

        List<Result> newResults = new ArrayList<Result>(){
            {
                add(new Result("꽝", 0));
                add(new Result("5000", 1));
                add(new Result("꽝", 2));
                add(new Result("3000", 3));
            }
        };

        assertThat(originResult).isEqualTo(newResults);
    }
}