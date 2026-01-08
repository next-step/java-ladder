package nextstep.ladder.factory;

import nextstep.ladder.domain.Line;
import nextstep.ladder.generator.FixedLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineFactoryTest {
    @Test
    void 사람이_4명이면_가로선은_3개이다() {
        LineFactory lineFactory = new LineFactory(new FixedLineGenerator(true, false, true));
        Line line = lineFactory.create(4);

        Assertions.assertThat(line.getPoints()).hasSize(3);
    }

}
