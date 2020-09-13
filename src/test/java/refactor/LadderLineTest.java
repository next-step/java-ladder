package refactor;

import org.junit.jupiter.api.Test;
import refactor.domain.LadderLine;
import refactor.domain.pointGenerate.PointStrategy;
import refactor.domain.pointGenerate.RandomPoint;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        PointStrategy pointStrategy = new RandomPoint();
        System.out.println(LadderLine.init(sizeOfPerson, pointStrategy));
    }

    @Test
    public void move() {
        PointStrategy pointStrategy = new RandomPoint();
        LadderLine line = LadderLine.init(2, pointStrategy);
        System.out.println("ladder result : " + line.move(0));
    }
}