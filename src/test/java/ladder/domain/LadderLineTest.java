package ladder.domain;

import org.junit.Test;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.create(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.create(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
