package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    Results results;

    @BeforeEach
    void init(){
        results = new Results(new String[]{"A", "B"});
    }

    @Test
    void getResults() {
        var acutualResults = results.getResults();
        var expectResults = new Results(new String[]{"A", "B"});

        assertThat(acutualResults).isEqualTo(expectResults.getResults());
    }

    @Test
    void getResultByIndexTest() {
        var acutualResult = results.getResultByIndex(1);
        var expectResult = "B";

        assertThat(acutualResult).isEqualTo(expectResult);
    }
}