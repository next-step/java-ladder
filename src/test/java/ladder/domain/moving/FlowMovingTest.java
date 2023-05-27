package ladder.domain.moving;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import ladder.domain.line.Line;
import org.junit.jupiter.api.Test;

class FlowMovingTest {

    @Test
    void 결정_() {
        List.of(
            Line.of(x -> List.of(true, false, false, true), 5),
            Line.of(x -> List.of(false, true, false, false), 5),
            Line.of(x -> List.of(false, true, false, true), 5),
            Line.of(x -> List.of(true, false, false, true), 5),
            Line.of(x -> List.of(true, false, true, false), 5),
            Line.of(x -> List.of(false, false, true, false), 5),
            Line.of(x -> List.of(true, false, true, false), 5),
            Line.of(x -> List.of(true, false, true, false), 5),
            Line.of(x -> List.of(false, false, false, true), 5),
            Line.of(x -> List.of(true, false, true, false), 5));
        assertAll(
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(true, false, false, true), 5), 0)).isEqualTo(Moving.RIGHT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(false, true, false, false), 5), 1)).isEqualTo(Moving.RIGHT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(false, true, false, true), 5), 2)).isEqualTo(Moving.LEFT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(true, false, false, true), 5), 1)).isEqualTo(Moving.LEFT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(true, false, true, false), 5), 0)).isEqualTo(Moving.RIGHT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(false, false, true, false), 5), 1)).isEqualTo(Moving.FORWARD),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(true, false, true, false), 5), 1)).isEqualTo(Moving.LEFT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(true, false, true, false), 5), 0)).isEqualTo(Moving.RIGHT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(false, false, false, true), 5), 1)).isEqualTo(Moving.FORWARD),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(true, false, true, false), 5), 1)).isEqualTo(Moving.LEFT)
        );
    }

    @Test
    void 결정() {
        assertAll(
            () -> assertThat(FlowMoving.instance().nextMoving(Line.of(x->List.of(true), 2), 0)).isEqualTo(Moving.RIGHT),
            () -> assertThat(FlowMoving.instance().nextMoving(Line.of(x->List.of(false), 2), 0)).isEqualTo(Moving.FORWARD),
            () -> assertThat(FlowMoving.instance().nextMoving(Line.of(x->List.of(false), 2), 1)).isEqualTo(Moving.FORWARD),
            () -> assertThat(FlowMoving.instance().nextMoving(Line.of(x->List.of(true), 2), 1)).isEqualTo(Moving.LEFT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x->List.of(false, false), 3), 1)).isEqualTo(Moving.FORWARD),
            () -> assertThat(FlowMoving.instance().nextMoving(Line.of(x->List.of(true, false), 3), 1)).isEqualTo(Moving.LEFT),
            () -> assertThat(FlowMoving.instance().nextMoving(Line.of(x->List.of(false, true), 3), 1)).isEqualTo(Moving.RIGHT)
        );
    }

    @Test
    void 생성() {
        assertAll(
            () -> assertThat(FlowMoving.instance().nextMoving(
                Line.of(x -> List.of(true, false, false), 4), 1)).isEqualTo(Moving.LEFT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(true, false, false), 4), 0)).isEqualTo(Moving.RIGHT),
            () -> assertThat(
                FlowMoving.instance().nextMoving(Line.of(x -> List.of(true, false, false), 4), 2)).isEqualTo(Moving.FORWARD),
            () -> assertThat(FlowMoving.instance().nextMoving(null, 1)).isEqualTo(Moving.STOP)
        );
    }

}