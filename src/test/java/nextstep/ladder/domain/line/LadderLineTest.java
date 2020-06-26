package nextstep.ladder.domain.line;

import nextstep.ladder.domain.line.LadderLine;
import nextstep.ladder.generator.RandomPointGenerator;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, new RandomPointGenerator()));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, new RandomPointGenerator());
        System.out.println("ladder result : " + line.move(0));
    }
}
