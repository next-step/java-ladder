package ladderTDD.domain;

import ladderTDD.domain.levels.BasicLadderLevel;
import ladderTDD.player.People;
import org.junit.Test;

import static org.junit.Assert.*;

public class LadderTest {

    @Test
    public void init() {
        System.out.println(Ladder.initLadder(new BasicLadderLevel(), new People("a,b,c")));
    }

}