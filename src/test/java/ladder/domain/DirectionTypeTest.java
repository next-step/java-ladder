package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void 둘다_TRUE인경우_예외처리하는지() {
        DirectionType directionType = DirectionType.mathDirectionType(true, true);
    }

    @Test
    public void 줄이_겹치는_경우_테스트() {
        DirectionType directionType = DirectionType.isOverLapped(true);
        boolean result = directionType.isRight();
        assertThat(result).isEqualTo(false);
    }
}