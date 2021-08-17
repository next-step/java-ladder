package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LegTest {
    @Test
    @DisplayName("특정 height 위치에 line 있는지 확인")
    public void hasLine() {
        Leg leg0 = new Leg(0, 2);
        Leg leg1 = new Leg(1, 2);

        assertThat(leg0.hasLine(new CoordinateValue(1))).isFalse();

        Line line = new Line(1);
        line.register(leg0, leg1);

        assertThat(leg0.hasLine(new CoordinateValue(1))).isTrue();
    }
}