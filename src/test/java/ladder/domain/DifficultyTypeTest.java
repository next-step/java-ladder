package ladder.domain;

import org.junit.Test;

public class DifficultyTypeTest {

    @Test(expected = IllegalArgumentException.class)
    public void 둘다_TRUE인경우_예외처리하는지() {
        DifficultyType directionType = DifficultyType.of("꺄");
    }

}