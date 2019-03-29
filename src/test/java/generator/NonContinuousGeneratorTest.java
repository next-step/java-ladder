package generator;

import generator.impl.NonContinuousGenerator;
import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NonContinuousGeneratorTest {

    @Test
    public void test_참이_겹치지_않는_부울목록_생성() {
        BooleansGenerator generator = new NonContinuousGenerator(() -> true, true);

        assertThat(generator.generate(6))
                .isEqualTo(Arrays.asList(true, false, true, false, true, false));
    }

    @Test
    public void test_거짓이_겹치지_않는_부울목록_생성() {
        BooleansGenerator generator = new NonContinuousGenerator(() -> false, false);

        assertThat(generator.generate(6))
                .isEqualTo(Arrays.asList(false, true, false, true, false, true));
    }

    @Test
    public void test_참이_겹치지_않는_랜덤_부울목록_생성() {
        BooleansGenerator generator = new NonContinuousGenerator(new RandomBooleanGenerator(), true);

        for (int i = 0; i < 100; i++) {
            assertThat(generator.generate(6))
                    .hasSize(6)
                    .doesNotContainSequence(true, true);
        }
    }

    @Test
    public void test_거짓이_겹치지_않는_랜덤_부울목록_생성() {
        BooleansGenerator generator = new NonContinuousGenerator(new RandomBooleanGenerator(), false);

        for (int i = 0; i < 100; i++) {
            assertThat(generator.generate(6))
                    .hasSize(6)
                    .doesNotContainSequence(false, false);
        }
    }
}
