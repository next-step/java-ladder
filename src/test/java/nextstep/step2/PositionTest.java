package nextstep.step2;

import nextstep.step2.VO.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PositionTest {

    @Test
    public void PositionTest() {
        Position position = new Position(4);

        position = position.moveToLeft();
        assertThat(position.getPosition()).isEqualTo(3);

        position = position.moveToDown();
        assertThat(position.getPosition()).isEqualTo(3);

        position = position.moveToRight();
        assertThat(position.getPosition()).isEqualTo(4);
    }
}
