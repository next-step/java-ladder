package laddergame.domain;

import laddergame.service.LadderPointGenerator;
import org.junit.Test;

import java.util.ArrayList;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;

public class LadderLineTest {

    private static LadderPointGenerator falseGenerator = () -> false;
    private static LadderPointGenerator trueGenerator = () -> true;

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void initFirst_for_Point_toRight_FALSE() {
        Point expected = new Point(0, Direction.of(FALSE, FALSE));
        Point actual = LadderLine.initFirst(new ArrayList(), falseGenerator);

        assertEquals(expected, actual);
    }

    @Test
    public void initFirst_for_Point_toRight_TRUE() {
        Point expected = new Point(0, Direction.of(FALSE, TRUE));
        Point actual = LadderLine.initFirst(new ArrayList(), trueGenerator);

        assertEquals(expected, actual);
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}