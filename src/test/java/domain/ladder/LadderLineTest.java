package domain.ladder;

import org.junit.Test;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, 0));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, 100);
    }
}
