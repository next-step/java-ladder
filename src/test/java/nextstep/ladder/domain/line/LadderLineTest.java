package nextstep.ladder.domain.line;

import org.junit.jupiter.api.Test;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.of(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.of(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
