package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    @Test
    void test_nextFloor() {
        // Given
        FloorGenerator floorGenerator = new FloorGenerator(RandomLinkGenerator.getInstance());
        Floor firstFloor = floorGenerator.create(5);
        Floor secondFloor = floorGenerator.create(5);

        // When
        firstFloor.next(secondFloor);

        // Then
        Floor nextFloor = firstFloor.getNextFloor();
        assertEquals(secondFloor, nextFloor);
        assertTrue(firstFloor.hasNext());
    }

}