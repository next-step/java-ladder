package ladder.domain;

import ladder.utils.LadderPointGeneratorByDifficulty;
import ladder.utils.PointGenerator;
import org.junit.Test;

public class LineTest {


    @Test
    public void init() {
        int sizeOfPerson = 5;
        PointGenerator generator = new LadderPointGeneratorByDifficulty("상");
        System.out.println(Line.newLine(sizeOfPerson, generator));
    }

    @Test
    public void move() {
        PointGenerator generator = new LadderPointGeneratorByDifficulty("상");
        Line line = Line.newLine(2, generator);
        System.out.println("ladder result : " + line.moveToNextPoint(0));
    }
}