package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultsTest {
    @Test
    void create() {
        Results result = Results.of("꽝,3000,꽝,5000");
        assertThat(result.getResults()).isEqualTo(Arrays.asList("꽝","3000","꽝","5000"));
    }
}
