package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    @Test
    void test_nextFloor() {
        // Given
        FloorGenerator floorGenerator = new FloorGenerator(RandomLinkGenerator.getInstance(), new LadderLine(5));
        Floor firstFloor = floorGenerator.create();
        Floor secondFloor = floorGenerator.create();

        // When
        firstFloor.next(secondFloor);

        // Then
        Floor nextFloor = firstFloor.getNextFloor();
        assertEquals(secondFloor, nextFloor);
        assertTrue(firstFloor.hasNext());
    }

}