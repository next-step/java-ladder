package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Result;
import step3.domain.Results;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    @Test
    @DisplayName("Results 생성 테스트")
    void resultsTest() {
        assertThat(new Results()).isEqualTo(new Results());
    }

    @Test
    @DisplayName("포지션에 따른 결과 값 반환")
    void returnOfOnePosition() {
        Results results = new Results(Arrays.asList(new Result("꽝"), new Result("5000")));
        assertThat(results.oneResult(1)).isEqualTo(new Result("5000"));
    }

    @Test
    @DisplayName("포지션에 따른 결과 값 반환")
    void returnOfAllPosition() {
        Results results = new Results(Arrays.asList(new Result("꽝"), new Result("5000")));
        assertThat(results.allResult(results)).isEqualTo(new Results(Arrays.asList(new Result("꽝"), new Result("5000"))));
    }


}
