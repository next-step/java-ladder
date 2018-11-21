package ladder.domain;

import ladder.utils.LadderPointGeneratorByDifficulty;
import ladder.utils.PointGenerator;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void 둘다_TRUE인경우_예외처리하는지() {
        DirectionType directionType = DirectionType.matchDirectionType(true, true);
    }

    @Test
    public void 줄이_겹치는_경우_테스트() {
        PointGenerator generator = new LadderPointGeneratorByDifficulty("상");
        DirectionType directionType = DirectionType.isOverLapped(true, generator);
        boolean result = directionType.isRight();
        assertThat(result).isEqualTo(false);
    }
}