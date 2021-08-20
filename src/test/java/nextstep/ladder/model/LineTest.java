package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {
    private static final CoordinateValue COORDINATE_VALUE_2 = new CoordinateValue(2);
    private static final CoordinateValue COORDINATE_VALUE_3 = new CoordinateValue(3);

    private static final Leg legWidth0 = new Leg(CoordinateValue.ZERO, CoordinateValue.ONE);
    private static final Leg legWidth1 = new Leg(CoordinateValue.ONE, CoordinateValue.ONE);
    private static final Leg legWidth2 = new Leg(COORDINATE_VALUE_2, CoordinateValue.ONE);
    private static final Leg legWidth3 = new Leg(COORDINATE_VALUE_3, CoordinateValue.ONE);

    @Test
    @DisplayName("leg 의 같은 height 라도 인접한 leg 가 아니면 등록 가능")
    public void register() {
        Line existLine = new Line(CoordinateValue.ONE);
        existLine.register(legWidth0, legWidth1);

        Line newLine = new Line(CoordinateValue.ONE);
        newLine.register(legWidth3, legWidth2);
    }

    @Test
    @DisplayName("leg 의 같은 height 에 다른 Line 이 있으면 등록 무시.")
    public void registerSameHeight() {
        Line existLine = new Line(CoordinateValue.ONE);
        existLine.register(legWidth0, legWidth1);

        Line newLine = new Line(CoordinateValue.ONE);
        newLine.register(legWidth1, legWidth2);

        assertThat(legWidth2.hasLine(CoordinateValue.ONE)).isFalse();
    }

    @Test
    @DisplayName("같은 위치에 두개의 line 은 등록 무시.")
    public void registerSameLine() {
        Line existLine = new Line(CoordinateValue.ONE);
        existLine.register(legWidth0, legWidth1);

        Line newLine = new Line(CoordinateValue.ONE);
        newLine.register(legWidth0, legWidth1);

        assertThat(legWidth1.getLinesSize()).isEqualTo(1);
    }

    @Test
    @DisplayName("height 가 같은지 판단.")
    public void heightIs() {
        Line line = new Line(CoordinateValue.ONE);

        assertThat(line.heightIs(CoordinateValue.ONE)).isTrue();
        assertThat(line.heightIs(COORDINATE_VALUE_2)).isFalse();
    }
}