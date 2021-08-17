package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {
    private static final int HEIGHT_1 = 1;

    private static final Leg legWidth0 = new Leg(0, HEIGHT_1);
    private static final Leg legWidth1 = new Leg(1, HEIGHT_1);
    private static final Leg legWidth2 = new Leg(2, HEIGHT_1);
    private static final Leg legWidth3 = new Leg(3, HEIGHT_1);

    @Test
    @DisplayName("leg 의 같은 height 라도 인접한 leg 가 아니면 등록 가능")
    public void register() {
        Line existLine = new Line(HEIGHT_1);
        existLine.register(legWidth0, legWidth1);

        Line newLine = new Line(HEIGHT_1);
        newLine.register(legWidth3, legWidth2);
    }

    @Test
    @DisplayName("leg 의 같은 height 에 다른 Line 이 있으면 등록 무시.")
    public void registerSameHeight() {
        Line existLine = new Line(HEIGHT_1);
        existLine.register(legWidth0, legWidth1);

        Line newLine = new Line(HEIGHT_1);
        newLine.register(legWidth1, legWidth2);

        assertThat(newLine).hasFieldOrPropertyWithValue("leftLeg", null);
        assertThat(newLine).hasFieldOrPropertyWithValue("rightLeg", null);
    }

    @Test
    @DisplayName("같은 위치에 두개의 line 은 등록 무시.")
    public void registerSameLine() {
        Line existLine = new Line(HEIGHT_1);
        existLine.register(legWidth0, legWidth1);

        Line newLine = new Line(HEIGHT_1);
        newLine.register(legWidth0, legWidth1);

        assertThat(newLine).hasFieldOrPropertyWithValue("leftLeg", null);
        assertThat(newLine).hasFieldOrPropertyWithValue("rightLeg", null);
    }

    @Test
    @DisplayName("height 가 같은지 판단.")
    public void heightIs() {
        Line line = new Line(HEIGHT_1);

        assertThat(line.heightIs(new CoordinateValue(HEIGHT_1))).isTrue();
        assertThat(line.heightIs(new CoordinateValue(2))).isFalse();
    }
}