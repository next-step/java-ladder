package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {
    private static final CoordinateValue COORDINATE_VALUE_0 = CoordinateValue.ZERO;
    private static final CoordinateValue COORDINATE_VALUE_2 = new CoordinateValue(2);

    @Test
    @DisplayName("height 가 같은지 판단.")
    public void heightIs() {
        Line line = new Line(COORDINATE_VALUE_0);

        assertThat(line.heightIs(COORDINATE_VALUE_0)).isTrue();
        assertThat(line.heightIs(COORDINATE_VALUE_2)).isFalse();
    }
}