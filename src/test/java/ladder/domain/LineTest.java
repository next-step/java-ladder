package ladder.domain;

import org.junit.Test;

public class LineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(Line.newLine(sizeOfPerson));
    }

    @Test
    public void move() {
        Line line = Line.newLine(2);
        System.out.println("ladder result : " + line.moveToNextPoint(0));
    }
}