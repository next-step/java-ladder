package ladder.tdd;

import org.junit.jupiter.api.Test;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, () -> true));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, () -> true);
        System.out.println("ladder result : " + line.move(0));
    }
}
