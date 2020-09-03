package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(Line.init(sizeOfPerson));
    }

    @Test
    public void move() {
        Line line = Line.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
