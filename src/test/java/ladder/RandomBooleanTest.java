package ladder;

import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomBooleanTest {
    @Test
    public void RandomBoolean() {
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
    public void 확률설정테스트() {
        // given
        RandomBoolean randomBoolean = new RandomBooleanGenerator();
        // when
        boolean expectTrueRandomBoolean = randomBoolean.randomBoolean(100);
        boolean expectFalseRandomBoolean = randomBoolean.randomBoolean(0);
        // then
        assertThat(expectTrueRandomBoolean).isTrue();
        assertThat(expectFalseRandomBoolean).isFalse();
    }
}
