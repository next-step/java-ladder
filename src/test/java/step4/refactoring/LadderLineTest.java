package step4.refactoring;

import org.junit.jupiter.api.Test;
import step4.strategy.LineStrategy;

class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson, new LineStrategy() {
            @Override
            public boolean hasLine() {
                return true;
            }
        }));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2, new LineStrategy() {
            @Override
            public boolean hasLine() {
                return true;
            }
        });
        System.out.println("ladder result : " + line.move(0));
    }
}
