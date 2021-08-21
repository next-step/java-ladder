package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LegTest {
    private static final CoordinateValue COORDINATE_VALUE_0 = CoordinateValue.ZERO;
    private static final CoordinateValue COORDINATE_VALUE_1 = CoordinateValue.ONE;
    private static final CoordinateValue COORDINATE_VALUE_2 = new CoordinateValue(2);
    private static final CoordinateValue COORDINATE_VALUE_3 = new CoordinateValue(3);

    private Leg LEG_WIDTH_0;
    private Leg LEG_WIDTH_1;
    private Leg LEG_WIDTH_2;
    private Leg LEG_WIDTH_3;

    @BeforeEach
    public void init() {
        LEG_WIDTH_0 = new Leg(COORDINATE_VALUE_0, COORDINATE_VALUE_2);
        LEG_WIDTH_1 = new Leg(COORDINATE_VALUE_1, COORDINATE_VALUE_2);
        LEG_WIDTH_2 = new Leg(COORDINATE_VALUE_2, COORDINATE_VALUE_2);
        LEG_WIDTH_3 = new Leg(COORDINATE_VALUE_3, COORDINATE_VALUE_2);
    }

    @Test
    @DisplayName("특정 height 위치에 line 있는지 확인")
    public void hasLine() {
        assertThat(LEG_WIDTH_0.hasLine(COORDINATE_VALUE_1)).isFalse();

        Line line = new Line(COORDINATE_VALUE_1);
        LEG_WIDTH_0.register(line);

        assertThat(LEG_WIDTH_0.hasLine(COORDINATE_VALUE_1)).isTrue();
    }

    @Test
    @DisplayName("특정 height 에 주어진 leg 와 바로 연결되어 있는지 확인")
    public void directlyConnected() {
        assertThat(LEG_WIDTH_0.directlyConnected(LEG_WIDTH_1, COORDINATE_VALUE_1)).isFalse();

        Line line = new Line(COORDINATE_VALUE_1);
        LEG_WIDTH_0.register(line);
        LEG_WIDTH_1.register(line);

        assertThat(LEG_WIDTH_0.directlyConnected(LEG_WIDTH_1, COORDINATE_VALUE_1)).isTrue();
    }


    @Test
    @DisplayName("등록 성공")
    public void register() {
        Line existLine = new Line(COORDINATE_VALUE_0);
        LEG_WIDTH_0.register(existLine);

        assertThat(LEG_WIDTH_0.hasLine(COORDINATE_VALUE_0)).isTrue();
    }

    @Test
    @DisplayName("leg 의 같은 height 에 다른 Line 이 있으면 등록 무시.")
    public void registerSameHeight() {
        Line existLine = new Line(COORDINATE_VALUE_0);
        LEG_WIDTH_0.register(existLine);

        Line newLine = new Line(COORDINATE_VALUE_0);
        LEG_WIDTH_0.register(newLine);

        assertThat(LEG_WIDTH_0.getLinesSize()).isEqualTo(1);
    }
}