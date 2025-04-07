package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    @Test
    @DisplayName("연속된 가로선이 생성되지 않는다")
    void noConsecutiveConnection() {
        int numOfPlayers = 5;
        Line line = Line.of(numOfPlayers, new TestPointStrategy(List.of(true, true, true, true)));

        for (int i = 0; i < numOfPlayers - 1; i++) {
            assertFalse(line.isConnected(i) && line.isConnected(i + 1));
        }
    }
}
