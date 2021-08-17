package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {
    @Test
    @DisplayName("leg 의 같은 height 라도 인접한 leg 가 아니면 등록 가능")
    public void register() {
        Leg leg0 = new Leg(0, 2);
        Leg leg1 = new Leg(1, 2);
        Line existLine = new Line(1);
        existLine.register(leg0, leg1);
        Leg leg2 = new Leg(2, 2);
        Leg leg3 = new Leg(3, 2);
        Line newLine = new Line(1);
        newLine.register(leg3, leg2);
    }

    @Test
    @DisplayName("leg 의 같은 height 에 다른 Line 이 있으면 안된다")
    public void registerSameHeight() {
        Leg leg0 = new Leg(0, 2);
        Leg leg1 = new Leg(1, 2);
        Line existLine = new Line(1);
        existLine.register(leg0, leg1);
        Leg leg2 = new Leg(2, 2);

        Line newLine = new Line(1);
        newLine.register(leg1, leg2);

        assertThat(newLine).hasFieldOrPropertyWithValue("leftLeg", null);
        assertThat(newLine).hasFieldOrPropertyWithValue("rightLeg", null);
    }

    @Test
    @DisplayName("같은 위치에 두개의 line 을 등록할 수 없다")
    public void registerSameLine() {
        Leg leg0 = new Leg(0, 2);
        Leg leg1 = new Leg(1, 2);
        Line existLine = new Line(1);
        existLine.register(leg0, leg1);

        Line newLine = new Line(1);
        newLine.register(leg0, leg1);

        assertThat(newLine).hasFieldOrPropertyWithValue("leftLeg", null);
        assertThat(newLine).hasFieldOrPropertyWithValue("rightLeg", null);
    }
}