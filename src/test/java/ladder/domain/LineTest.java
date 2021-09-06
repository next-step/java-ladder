package ladder.domain;

import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        final Line init = Line.init(5);
    }

    @Test
    public void move() {
        Line line = Line.init(2);
        int move = line.move(0);
    }
}