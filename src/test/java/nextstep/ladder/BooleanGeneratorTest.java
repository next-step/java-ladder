package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class BooleanGeneratorTest {
    @Test
    void create() {
        BooleanGenerator testingBooleanGenerator = new TestingBooleanGenerator(true, false, true);
        assertAll(
                () -> assertThat(testingBooleanGenerator.nextBoolean()).isTrue(),
                () -> assertThat(testingBooleanGenerator.nextBoolean()).isFalse(),
                () -> assertThat(testingBooleanGenerator.nextBoolean()).isTrue()
        );
    }

}
