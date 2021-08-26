package laddergameplay.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @Test
    @DisplayName("Results 생성")
    void createAndFind() {
        // given
        String resultsName = "3000,lose,2000,lose";
        List<String> resultsList = Arrays.asList(resultsName.split(","));

        // when
        Results results = new Results(resultsList);

        // then
        assertThat(results.getResults().size()).isEqualTo(4);
        assertThat(results.getResults().get(0)).isEqualTo(new Result("3000"));
    }
}
