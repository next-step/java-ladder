package engine;

import factory.LinesFactoryBean;
import nextstep.ladder.domain.LadderExecutor;
import nextstep.ladder.domain.MachingResult;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.strategy.TrueLineStrategy;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesFactoryBeanTest {

    @Test
    void createNextStepLadderFactory() {
        LinesCreator linesCreator = LinesFactoryBean.createNextStepLadderFactory(3, 5, new TrueLineStrategy());
        Participants participants = new Participants("a,b,c");
        LadderExecutor ladderExecutor = new LadderExecutor(linesCreator, participants);
        MachingResult machingResult = ladderExecutor.play();

        assertThat(machingResult.getMachingResultMap()).hasSize(3);
    }
}
