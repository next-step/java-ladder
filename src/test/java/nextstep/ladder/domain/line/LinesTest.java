package nextstep.ladder.domain.line;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    void create() {
        int ladderHeight = 3;
        int ladderWidth = 4;
        Lines lines = new Lines(ladderHeight, ladderWidth);

        Assertions.assertThat(lines).isNotNull();
        Assertions.assertThat(lines.getLines().size()).isEqualTo(3);
        Assertions.assertThat(lines.getLines().get(0).getPoints().size()).isEqualTo(4);
    }
}