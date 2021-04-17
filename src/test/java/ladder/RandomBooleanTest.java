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
            @Override
            public boolean randomBoolean() {
                return true;
            }
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
            @Override
            public boolean randomBoolean() {
                return false;
            }
        };

        // when
        boolean resultRandomBoolean = randomBoolean.randomBoolean();

        // then
        assertThat(resultRandomBoolean).isFalse();
    }
}
