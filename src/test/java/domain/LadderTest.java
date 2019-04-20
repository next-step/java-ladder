package domain;

import org.junit.Before;
import org.junit.Test;
import util.Console;

public class LadderTest {
    private Ladder ladder;

    @Before
    public void Ladder_생성() {
        this.ladder = new Ladder(4,Level.INTERMEDIATE);
        Console.print(this.ladder.toString());
    }

    @Test
    public void resultIndex() {
        System.out.println(this.ladder.calcStartIndex(2));
    }
}
