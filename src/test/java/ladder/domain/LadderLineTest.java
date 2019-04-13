package ladder.domain;

import org.junit.Before;
import org.junit.Test;

public class LadderLineTest {
    private BooleanGenerator booleanGenerator;

    @Before
    public void setUp() throws Exception {
        Level level = Level.findLevel("middle");
        this.booleanGenerator = new BooleanGenerator(level);
    }

    @Test
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = new LadderLine(sizeOfPerson, booleanGenerator);
        System.out.println(ladderLine);
    }

    @Test
    public void move() {
        LadderLine line = new LadderLine(2, booleanGenerator);
        System.out.println("ladder result : " + line.move(0));
    }
}