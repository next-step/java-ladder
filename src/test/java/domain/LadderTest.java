package domain;

import generator.impl.RandomBooleanGenerator;
import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void test_겹치는_라인을_제외하고_랜덤으로_라인을_생성() {
        int length = 8;
        for (int i = 0; i < 100; i++) {
            Ladder ladder = new Ladder(length, new RandomBooleanGenerator());
            assertThat(ladder.getLines())
                    .hasSize(length)
                    .doesNotContainSequence(true, true);
        }
    }

    @Test
    public void test_겹치는_라인을_제외하고_모든_라인을_생성() {
        int length = 8;
        Ladder ladder = new Ladder(length, () -> true);

        assertThat(ladder.getLines())
                .hasSize(length)
                .isEqualTo(Arrays.asList(false, true, false, true, false, true, false, true));
    }

    @Test
    public void test_라인을_생성하지_않음() {
        int length = 8;
        Ladder ladder = new Ladder(length, () -> false);

        assertThat(ladder.getLines())
                .isEqualTo(Arrays.asList(false, false, false, false, false, false, false, false));
    }
}
