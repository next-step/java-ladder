package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTests {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        List<String> resultsList = new ArrayList<>(Arrays.asList("꽝", "5000", "꽝", "3000"));
        Results results = Results.of(resultsList);

        assertThat(results).isEqualTo(Results.of(Arrays.asList("꽝", "5000", "꽝", "3000")));
    }
}
