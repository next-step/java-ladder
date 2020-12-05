package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorGeneratorTest {

    private static final int LADDER_LINE_COUNT = 4;

    @Test
    @DisplayName("층을 생성하고 지정된 숫자의 점이 생성된다")
    void test_create_floor() {
        // Given
        FloorGenerator floorGenerator
                = new FloorGenerator(RandomLinkGenerator.getInstance(), new LadderLine(LADDER_LINE_COUNT));

        // When
        Floor floor = floorGenerator.create();

        // Then
        assertNotNull(floor);
        validatePoint(floor.getStartPoint());
    }

    private void validatePoint(Point startPoint) {
        Point current = startPoint;
        int count = 1;
        while(current.hasNext()) {
            current = current.getNext();
            count++;
        }
        assertEquals(count, LADDER_LINE_COUNT);
    }

}