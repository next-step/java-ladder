package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("사다리의 하나의 행이 오직 1열만을 가질때, 가로라인은 가질수 없다.")
    void createOnlyOneLine() {
        Line line = new Line(1);
        assertThat(line.getPoints().get(0)).isEqualTo(false);

    }

}