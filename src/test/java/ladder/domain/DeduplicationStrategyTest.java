package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DeduplicationStrategyTest {
    @Test
    void 중복방지() {
        DeduplicationStrategy deduplicationStrategy = new DeduplicationStrategy();
        List<Boolean> booleans = Arrays.asList(true);

        Assertions.assertThat(deduplicationStrategy.deduplicationInsert(booleans, 1)).isEqualTo(false);
    }
}
