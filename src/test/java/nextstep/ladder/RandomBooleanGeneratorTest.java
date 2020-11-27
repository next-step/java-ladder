package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RandomBooleanGeneratorTest {
    @Test
    void name() {
        RandomBooleanGenerator testingRandomBooleanGenerator = new TestingRandomBooleanGenerator(true, false, true);
        assertAll(
                () -> assertThat(testingRandomBooleanGenerator.nextBoolean()).isTrue(),
                () -> assertThat(testingRandomBooleanGenerator.nextBoolean()).isTrue(),
                () -> assertThat(testingRandomBooleanGenerator.nextBoolean()).isTrue()
        );
    }
}
