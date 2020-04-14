package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LadderLineTest {

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
