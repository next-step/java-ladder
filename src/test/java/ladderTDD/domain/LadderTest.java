package ladderTDD.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class LadderTest {

    @Test
    public void init() {
        int height = 5;
        System.out.println(Ladder.initLadder(height));
    }

}