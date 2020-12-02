package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private static final int LADDER_HEIGHT_COUNT = 5;
    private static final int LADDER_LINE_COUNT = 4;

    private LinkGenerator linkGenerator = RandomLinkGenerator.getInstance();

    @Test
    @DisplayName("사라디가 생성되고 지정된 숫자의 층을 갖는다.")
    void test_create_ladder() {
        // Given
        FloorGenerator floorGenerator = new FloorGenerator(linkGenerator, new LadderLine(LADDER_LINE_COUNT));

        // When
        Ladder ladder = Ladder.create(new LadderHeight(LADDER_HEIGHT_COUNT), floorGenerator);

        // Then
        Floor firstFloor = ladder.getFirstFloor();
        validateFloor(firstFloor);
    }

    private void validateFloor(Floor firstFloor) {
        assertNotNull(firstFloor);

        Floor current = firstFloor;
        int count = 1;
        while(current.hasNext()) {
            current = current.getNextFloor();
            count++;
        }

        assertEquals(count, LADDER_HEIGHT_COUNT);
    }

}