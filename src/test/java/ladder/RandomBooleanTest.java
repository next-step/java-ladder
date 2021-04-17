package ladder;

import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBooleanTest {
    @Test
    public void RandomBooleanTrueTest() {
        // given
        RandomBoolean randomBoolean = new RandomBooleanGenerator() {
            private final int DEFAULT_PROBABILITY = 100;
        };
        // when
        boolean resultRandomBoolean = randomBoolean.randomBoolean();

        // then
        assertThat(resultRandomBoolean).isTrue();
    }

    @Test
    public void RandomBooleanFalseTest() {
        // given
        RandomBoolean randomBoolean = new RandomBooleanGenerator() {
            private final int DEFAULT_PROBABILITY = 0;
        };

        // when
        boolean resultRandomBoolean = randomBoolean.randomBoolean();

        // then
        assertThat(resultRandomBoolean).isFalse();
    }
}
