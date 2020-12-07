package nextstep.ladder.entity.ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void test_goDown() {
        // Given
        Ladder ladder = Ladder.init(new LadderHeight(5), 2);

        // When
        int arrivalPosition = ladder.goDown(0);

        // Then
        assertEquals(0, arrivalPosition);
    }
    
}