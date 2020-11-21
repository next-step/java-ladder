package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    @DisplayName("Results 의 사이즈가 정상적으로 받아져야 한다.")
    void getSize() {
        Results results = new Results(Arrays.asList(
                new Result("1"),
                new Result("22"),
                new Result("333"),
                new Result("4444"),
                new Result("55555")
        ));
        assertThat(results.getSize())
                .isEqualTo(5);
    }
}
