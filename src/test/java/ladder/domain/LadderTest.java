package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("높이 만큼 사다리의 line이 생성되었는지 확인한다.")
    void lineCreationTest() {
        int height = 5;
        int countOfPlayer = 3;
        Ladder ladder = new Ladder(height, countOfPlayer);

        Assertions.assertEquals(height, ladder.getLines().size());
    }
}
