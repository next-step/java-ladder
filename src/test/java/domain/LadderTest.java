package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    private static final int HEIGHT_OF_LADDER = 5;
    private static final int PARTICIPANT_SIZE = 10;
    private static final int FLOOR_SIZE = 5;

    @Test
    @DisplayName("Test floors constituted by ladder")
    void testConstituteFloors() {
        Ladder ladder = new Ladder(HEIGHT_OF_LADDER, PARTICIPANT_SIZE);
        int floorSize = ladder.getFloors().size();
        assertThat(floorSize).isEqualTo(FLOOR_SIZE);
    }
}
