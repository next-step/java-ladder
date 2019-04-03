package generator.bool.impl;

import org.junit.*;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;

public class ProbabilityBasedGeneratorTest {

    @Test
    public void test_100퍼센트() {
        BooleanSupplier generator = new ProbabilityBasedGenerator(100);
        for (int i = 0; i < 100; i++) {
            assertThat(generator.getAsBoolean())
                    .isEqualTo(true);
        }
    }

    @Test
    public void test_50퍼센트() {
        BooleanSupplier generator = new ProbabilityBasedGenerator(0);
        for (int i = 0; i < 100; i++) {
            assertThat(generator.getAsBoolean())
                    .isIn(true, false);
        }
    }

    @Test
    public void test_0퍼센트() {
        BooleanSupplier generator = new ProbabilityBasedGenerator(0);
        for (int i = 0; i < 100; i++) {
            assertThat(generator.getAsBoolean())
                    .isEqualTo(false);
        }
    }
}
