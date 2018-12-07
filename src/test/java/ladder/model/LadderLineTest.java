package ladder.model;

import org.junit.Test;

public class LadderLineTest {

    private LadderLine ladderLine;

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, Difficult.HIGH));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, Difficult.HIGH);
        System.out.println("ladder result : " + line.move(0));
    }
}
