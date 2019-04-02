package domain.ladder;

import generator.bool.impl.ProbabilityBasedGenerator;
import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void test_겹치는_라인을_제외하고_랜덤으로_라인을_생성() {
        int length = 8;
        for (int i = 0; i < 100; i++) {
            assertThat(Ladder.createLines(length, new ProbabilityBasedGenerator(50)))
                    .hasSize(length)
                    .doesNotContainSequence(true, true);
        }
    }

    @Test
    public void test_겹치는_라인을_제외하고_모든_라인을_생성() {
        int length = 8;

        assertThat(Ladder.createLines(length, () -> true))
                .hasSize(length)
                .isEqualTo(Arrays.asList(false, true, false, true, false, true, false, true));
    }

    @Test
    public void test_크기() {
        Ladder ladder = new Ladder(8, () -> true);

        assertThat(ladder.size())
            .isEqualTo(8);
    }

    @Test
    public void test_가로라인_출력() {
        Ladder ladder = new Ladder(8, () -> true);
        assertThat(ladder.beautify())
                .isEqualTo("    |-----|     |-----|     |-----|     |-----|");
    }

    @Test
    public void test_라인을_생성하지_않음() {
        int length = 8;

        assertThat(Ladder.createLines(length, () -> false))
                .isEqualTo(Arrays.asList(false, false, false, false, false, false, false, false));
    }

    @Test
    public void test_고정라인_포인트() {
        int length = 5;
        Ladder ladder = new Ladder(length, () -> true);

        assertThat(ladder.getPoints())
                .containsExactly(
                        new Point(0, Direction.RIGHT),
                        new Point(1, Direction.LEFT),
                        new Point(2, Direction.RIGHT),
                        new Point(3, Direction.LEFT),
                        new Point(4, Direction.DOWN));
    }

    @Test
    public void test_고정라인_이동() {
        int length = 5;
        Ladder ladder = new Ladder(length, () -> true);

        assertThat(ladder.move(0))
                .isEqualTo(1);
        assertThat(ladder.move(1))
                .isEqualTo(0);
        assertThat(ladder.move(2))
                .isEqualTo(3);
        assertThat(ladder.move(3))
                .isEqualTo(2);
        assertThat(ladder.move(4))
                .isEqualTo(4);
    }
}
