package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LegTest {
    private Leg LEG_WIDTH_0;
    private Leg LEG_WIDTH_1;

    @BeforeEach
    public void init() {
        LEG_WIDTH_0 = new Leg(0, 2);
        LEG_WIDTH_1 = new Leg(1, 2);
    }

    @Test
    @DisplayName("특정 height 위치에 line 있는지 확인")
    public void hasLine() {
        assertThat(LEG_WIDTH_0.hasLine(new CoordinateValue(1))).isFalse();

        Line line = new Line(1);
        line.register(LEG_WIDTH_0, LEG_WIDTH_1);

        assertThat(LEG_WIDTH_0.hasLine(new CoordinateValue(1))).isTrue();
    }

    @Test
    @DisplayName("특정 height 에 주어진 leg 와 바로 연결되어 있는지 확인")
    public void directlyConnected() {
        assertThat(LEG_WIDTH_0.directlyConnected(LEG_WIDTH_1, new CoordinateValue(1))).isFalse();

        Line line = new Line(1);
        line.register(LEG_WIDTH_0, LEG_WIDTH_1);

        assertThat(LEG_WIDTH_0.directlyConnected(LEG_WIDTH_1, new CoordinateValue(1))).isTrue();
    }
}