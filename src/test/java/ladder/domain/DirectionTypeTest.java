package ladder.domain;

import org.junit.Test;

public class DirectionTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void 둘다_TRUE인경우_예외처리하는지() {
        DirectionType directionType = DirectionType.mathDirectionType(true, true);
    }
}