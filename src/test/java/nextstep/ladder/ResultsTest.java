package nextstep.ladder;

import nextstep.ladder.drawPolicy.AllDraw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}