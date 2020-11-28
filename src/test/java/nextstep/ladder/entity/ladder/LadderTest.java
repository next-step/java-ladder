package nextstep.ladder.entity.ladder;

import nextstep.ladder.LadderController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    private LinkGenerator linkGenerator = RandomLinkGenerator.getInstance();
    private LadderConfiguration ladderConfiguration = new LadderConfiguration(5, 4);

    @Test
    void test_createLadder() {

        Ladder ladder = Ladder.create(ladderConfiguration, linkGenerator);

        System.out.println(ladder.toString());
    }
}