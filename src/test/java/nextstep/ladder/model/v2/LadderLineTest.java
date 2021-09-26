package nextstep.ladder.model.v2;

import org.junit.jupiter.api.Test;

class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, new RandomLadderPointGenerator()));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, new RandomLadderPointGenerator());
        System.out.println("ladder result : " + line.move(0));
    }
}