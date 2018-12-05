import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson, new LevelLadderLineGenerator(Level.상));
        System.out.println(ladderLine);
    }

    @Test
    public void move() {
        LadderLine init = LadderLine.init(2, new LevelLadderLineGenerator(Level.상));
        System.out.println("ladder result :" + init.move(0));
    }
}