package ladder;

import ladder.domain.Line;
import ladder.domain.Location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LineTest {

    @Test
    @DisplayName("라인 생성")
    void createLine() {
        assertDoesNotThrow(() -> new Line(5));
    }

    @Test
    @DisplayName("라인 이동시 왼쪽 오른쪽 한칸 범위내에서 움직인다.")
    void moveLine() {
        Line line = new Line(5);
        Location movedLocation = line.move(new Location(3));
        System.out.println(movedLocation.getLocation());
        assertTrue(movedLocation.equals(new Location(2)) ||
                movedLocation.equals(new Location(3)) ||
                movedLocation.equals(new Location(4))
        );
    }
}
