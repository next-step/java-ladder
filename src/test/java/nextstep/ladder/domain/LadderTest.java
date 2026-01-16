package nextstep.ladder.domain;

import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.generator.FixedLineGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void create() {
        LineFactory lineFactory = new LineFactory(new FixedLineGenerator(
                true, false, true,   // 1번째 Line
                false, true, false,  // 2번째 Line
                true, false, false   // 3번째 Line
        ));

        Ladder ladder = new Ladder(3, 4, lineFactory);

        assertThat(ladder.getLines()).hasSize(3);
    }

    @Test
    void 사다리를_타면_정해진_위치로_이동한다() {
        LineFactory factory = new LineFactory(new FixedLineGenerator(
                true, false, true,
                false, true, false,
                true, false, false
        ));
        Ladder ladder = new Ladder(3, 4, factory);

        assertThat(ladder.move(0)).isEqualTo(2);
        assertThat(ladder.move(1)).isEqualTo(1);
        assertThat(ladder.move(2)).isEqualTo(3);
        assertThat(ladder.move(3)).isEqualTo(0);
    }
}
