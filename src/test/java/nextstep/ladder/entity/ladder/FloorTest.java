package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    private static final int LADDER_LINE_COUNT = 5;

    @Test
    @DisplayName("다음 층과 연결이 성공적으로 이루어졌다.")
    void test_link_success() {
        // Given
        FloorGenerator floorGenerator = new FloorGenerator(RandomLinkGenerator.getInstance(), new LadderLine(LADDER_LINE_COUNT));
        Floor firstFloor = floorGenerator.create();
        Floor secondFloor = floorGenerator.create();

        // When
        firstFloor.next(secondFloor);

        // Then
        assertTrue(firstFloor.hasNext());
    }

    @Test
    @DisplayName("연결된 다음 층은 연결을 시도한 층과 같다.")
    void test_link_with_next_floor() {
        // Given
        FloorGenerator floorGenerator = new FloorGenerator(RandomLinkGenerator.getInstance(), new LadderLine(LADDER_LINE_COUNT));
        Floor firstFloor = floorGenerator.create();
        Floor secondFloor = floorGenerator.create();

        // When
        firstFloor.next(secondFloor);

        // Then
        Floor nextFloor = firstFloor.getNextFloor();
        assertEquals(secondFloor, nextFloor);
    }

    @Test
    @DisplayName("층은 시작점을 가진다")
    void test_start_point() {
        // Given
        FloorGenerator floorGenerator = new FloorGenerator(RandomLinkGenerator.getInstance(), new LadderLine(LADDER_LINE_COUNT));
        Floor floor = floorGenerator.create();

        // When
        Point startPoint = floor.getStartPoint();

        // Then
        assertNotNull(startPoint);
    }


}