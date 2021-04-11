package nextstep.refactoring.ladder;

import nextstep.refactoring.ladder.engine.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderPointTest {

    @Test
    @DisplayName("연결된 지점으로 이동한다.")
    void traverse() {
        LadderPoint firstPoint = LadderPoint.of(0, Direction.right());
        LadderPoint secondPoint = firstPoint.next();
        LadderPoint thirdPoint = secondPoint.next(false);

        assertAll(
            () -> assertThat(firstPoint.traverse()).isEqualTo(Position.of(1)),
            () -> assertThat(secondPoint.traverse()).isEqualTo(Position.of(0)),
            () -> assertThat(thirdPoint.traverse()).isEqualTo(Position.of(2))
        );
    }

}
