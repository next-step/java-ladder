package step4.domain;

import org.junit.jupiter.api.Test;

class LadderLineTest {
    @Test
    void init() {
        LadderLine ladderLine = LadderLine.init(5);
        for (Point point: ladderLine.getPoints()) {
            System.out.println(point.cross().before());
            System.out.println(point.cross().current());
            System.out.println();
        }
        System.out.println("ladder result 0 : " + ladderLine.move(0));
        System.out.println("ladder result 1 : " + ladderLine.move(1));
        System.out.println("ladder result 2 : " + ladderLine.move(2));
        System.out.println("ladder result 3 : " + ladderLine.move(3));
        System.out.println("ladder result 4 : " + ladderLine.move(4));

    }
}