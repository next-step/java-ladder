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
}
