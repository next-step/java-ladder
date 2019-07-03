package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("움직이기")
    public void ride() {
        Position position1 = new Position(0);
        Position position2 = new Position(1);
        Position position3 = new Position(2);

        DirectionLayer directionLayer = DirectionLayer.ofGenerator(2, count -> Arrays.asList(true, false));

        assertThat(position1.moveBy(directionLayer)).isEqualTo(new Position(1));
        assertThat(position2.moveBy(directionLayer)).isEqualTo(new Position(0));
        assertThat(position3.moveBy(directionLayer)).isEqualTo(new Position(2));
    }

}