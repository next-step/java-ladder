package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LadderLineTest {
    public static final LadderLine LINE = new LadderLine(ImprovingPointTest.POINTS);
    public static final LadderLine LINE2 = new LadderLine(ImprovingPointTest.POINTS2);

    @Test
    void init() {
        int countOfPerson = 5;
        System.out.println(LadderLine.init(countOfPerson));
    }

    @Test
    void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
