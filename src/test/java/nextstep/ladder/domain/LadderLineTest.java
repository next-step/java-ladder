package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

public class LadderLineTest {
    public static final LadderLine LINE = new LadderLine(ImprovingPointTest.POINTS);
    public static final LadderLine LINE2 = new LadderLine(ImprovingPointTest.POINTS2);

    @Test
    void move() {
        LadderLineCreator lineCreator = new LadderLineCreator();
        LadderLine line = lineCreator.create(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
