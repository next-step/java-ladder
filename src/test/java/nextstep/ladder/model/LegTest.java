package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LegTest {
    private static final CoordinateValue COORDINATE_VALUE_2 = new CoordinateValue(2);

    private Leg LEG_WIDTH_0;
    private Leg LEG_WIDTH_1;

    @BeforeEach
    public void init() {
        LEG_WIDTH_0 = new Leg(CoordinateValue.ZERO, COORDINATE_VALUE_2);
        LEG_WIDTH_1 = new Leg(CoordinateValue.ONE, COORDINATE_VALUE_2);
    }

    @Test
    @DisplayName("특정 height 위치에 line 있는지 확인")
    public void hasLine() {
        assertThat(LEG_WIDTH_0.hasLine(CoordinateValue.ONE)).isFalse();

        Line line = new Line(CoordinateValue.ONE);
        line.register(LEG_WIDTH_0, LEG_WIDTH_1);

        assertThat(LEG_WIDTH_0.hasLine(CoordinateValue.ONE)).isTrue();
    }

    @Test
    @DisplayName("특정 height 에 주어진 leg 와 바로 연결되어 있는지 확인")
    public void directlyConnected() {
        assertThat(LEG_WIDTH_0.directlyConnected(LEG_WIDTH_1, CoordinateValue.ONE)).isFalse();

        Line line = new Line(CoordinateValue.ONE);
        line.register(LEG_WIDTH_0, LEG_WIDTH_1);

        assertThat(LEG_WIDTH_0.directlyConnected(LEG_WIDTH_1, CoordinateValue.ONE)).isTrue();
    }
}