package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        line.move(0);
    }
}
