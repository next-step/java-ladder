package ladder_refactor;

import ladder_refactor.domain.LadderLine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        assertDoesNotThrow(() -> LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        assertDoesNotThrow(() -> System.out.println("ladder result : " + line.move(0)));
    }
}
