package domain;

import org.junit.Before;
import org.junit.Test;

public class LadderLineTest {
    LadderLine ladderLine;

    @Before
    public void init() {
        int countOfPerson = 5;
        ladderLine = LadderLine.init(countOfPerson);
    }

    @Test
    public void printLine() {
        System.out.println(this.ladderLine.printLine());
    }

    @Test
    public void move() {
        int startPoint = 4;
        System.out.println(this.ladderLine.movePoint(startPoint) - startPoint);
    }
}
