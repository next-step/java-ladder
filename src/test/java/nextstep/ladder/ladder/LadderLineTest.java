package nextstep.ladder.ladder;

import org.junit.jupiter.api.Test;

class LadderLineTest {

    @Test
    void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}