package step4;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.Bridge;
import step4.domain.Line;
import step4.domain.Lines;
import step4.domain.Position;

import static org.assertj.core.api.BDDAssertions.then;

class PositionTest {

    @Test
    @DisplayName("moveDown 동작시 정상적으로 position 이동하는지 테스트")
    void moveDown() {
        Lines lines = Lines.from(List.of(
            Line.from(List.of(new Bridge(false), new Bridge(false))),
            Line.from(List.of(new Bridge(true), new Bridge(false)))
        ));

        then(new Position(1).moveDown(lines, 1)).isEqualTo(new Position(0));
        then(new Position(0).moveDown(lines, 1)).isEqualTo(new Position(1));
    }
}