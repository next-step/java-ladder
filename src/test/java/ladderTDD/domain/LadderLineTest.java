package ladderTDD.domain;

import ladderTDD.domain.levels.BasicLadderLevel;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(new BasicLadderLevel(), sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(new BasicLadderLevel(), 2);
        System.out.println("ladder result : " + line.move(0));
    }
}