package ladder;

import ladder.model.LadderLineTdd;
import org.junit.jupiter.api.Test;

public class LadderLineTddTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLineTdd.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLineTdd line = LadderLineTdd.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
