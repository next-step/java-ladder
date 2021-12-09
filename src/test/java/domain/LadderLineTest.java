package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static domain.DirectionTest.*;

public class LadderLineTest {
    public static LadderLine FIRST_LINE = new LadderLine(Arrays.asList(
            new Point(0, LEFT_DIRECTION),
            new Point(1, RIGHT_DIRECTION),
            new Point(2, NO_DIRECTION)));
    public static LadderLine SECOND_LINE = new LadderLine(Arrays.asList(
            new Point(0, NO_DIRECTION),
            new Point(1, RIGHT_DIRECTION),
            new Point(2, LEFT_DIRECTION)));
    public static LadderLine THIRD_LINE = new LadderLine(Arrays.asList(
            new Point(0, LEFT_DIRECTION),
            new Point(1, RIGHT_DIRECTION),
            new Point(2, NO_DIRECTION)));

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
