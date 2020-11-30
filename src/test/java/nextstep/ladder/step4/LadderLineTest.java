package nextstep.ladder.step4;

import nextstep.ladder.domain.LadderLine;
import org.junit.jupiter.api.Test;

public class LadderLineTest {
    @Test
    void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
        System.out.println(ladderLine);
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
