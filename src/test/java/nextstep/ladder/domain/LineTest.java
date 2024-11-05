package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void 선_그어진_여부() {
        Line line = new Line(true);

        assertThat(line.isLine()).isTrue();
    }
}
