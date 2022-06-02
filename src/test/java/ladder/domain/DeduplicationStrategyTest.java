package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeduplicationStrategyTest {
    @Test
    void 중복방지() {
        DeduplicationStrategy deduplicationStrategy = new DeduplicationStrategy();
        Assertions.assertThat(deduplicationStrategy.deduplicationInsert(true)).isEqualTo(false);
    }
}
