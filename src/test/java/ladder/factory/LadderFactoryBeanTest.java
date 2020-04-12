package ladder.factory;

import ladder.engine.Ladder;
import ladder.engine.LadderRepository;
import ladder.engine.LadderResult;
import org.junit.jupiter.api.Test;

public class LadderFactoryBeanTest {
    @Test
    void create_and_play() {
        LadderRepository ladderRepository = LadderFactoryBean.createLadderFactory();
        Ladder ladder = ladderRepository.create(3, 5);
        LadderResult result = ladder.play();
        System.out.println(result);
    }
}
