package step2.domain;

import org.junit.jupiter.api.Test;
import step2.dto.Player;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    @Test
    void findResultTest() {
        final Results results = new Results(Arrays.asList(new Result(new Player("a"), 0),
                new Result(new Player("b"), 1),
                new Result(new Player("c"), 2)));
        final Result actual = results.findResult(new Player("b"));
        final Result expect = new Result(new Player("b"), 1);
        assertThat(actual).isEqualTo(expect);
   }
}