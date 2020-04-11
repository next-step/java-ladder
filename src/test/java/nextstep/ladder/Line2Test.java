package nextstep.ladder;

import nextstep.ladder.domain.Line2;
import org.junit.jupiter.api.Test;

public class Line2Test {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(Line2.init(sizeOfPerson));
    }

    @Test
    public void move() {
        Line2 line = Line2.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
