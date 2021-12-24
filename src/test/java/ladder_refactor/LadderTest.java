package ladder_refactor;

import ladder_refactor.domain.Ladder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("Ladder 생성")
    public void createLadder() {
        int sizeOfHeight = 5;
        int sizeOfPerson = 3;
        Assertions.assertDoesNotThrow(() -> Ladder.init(sizeOfHeight, sizeOfPerson));
    }

    @Test
    @DisplayName("사다리 타기")
    public void moveLadder() {
        Ladder ladder = Ladder.init(5, 3);
        Assertions.assertDoesNotThrow(() -> System.out.println(ladder.move(0)));
    }
}
