package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    @Test
    @DisplayName("사다리의 높이는 사용자가 입력한 높이와 동일해야 한다.")
    void testLadderHeightAndWidthEqualsUserInput() {
        int height = 4;
        int width = 5;

        Ladder ladder = new Ladder(height, width);

        assertEquals(height, ladder.getHeight());
        assertEquals(width, ladder.getWidth());
    }

    @Test
    @DisplayName("사용자 수만큼 사다리 라인이 생성되어야 한다..")
    void testLadderWidthEqualsUserCount() {
        int userCount = 5;
        Ladder ladder = new Ladder(5, userCount);

        assertEquals(userCount, ladder.getLines().size());
    }
}
