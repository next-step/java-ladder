package ladder.ladder;


import ladder.model.ladder.Line;
import org.junit.jupiter.api.Test;


public class LineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(Line.from(sizeOfPerson));
    }

    @Test
    public void move() {
        Line line = Line.from(2);
        System.out.println("ladder result : " + line.move(0));
    }

}
