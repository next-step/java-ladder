package ladder.factory;

import ladder.engine.Ladder;
import ladder.engine.LadderCreator;
import ladder.engine.LadderResult;
import org.junit.jupiter.api.Test;

public class LadderFactoryBeanTest {
    @Test
    void create_and_play() {
        LadderCreator ladderCreator = LadderFactoryBean.createLadderFactory();
        Ladder ladder = ladderCreator.create(3, 5);
        LadderResult result = ladder.play();
        System.out.println(result);
    }
}
