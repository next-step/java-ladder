package nextstep.ladder.domain;

import nextstep.ladder.util.RandomUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void createLine() {
        Line line1 = new Line(() -> RandomUtil.generatorPoints(2));
        assertThat(line1.getPoints()).hasSize(2);
        Line line2 = new Line(() -> RandomUtil.generatorPoints(4));
        assertThat(line2.getPoints()).hasSize(4);
    }

}
