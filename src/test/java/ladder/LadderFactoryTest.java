package ladder;

import org.junit.jupiter.api.Test;

import ladder.domain.Ladder;
import ladder.ui.LadderDataInput;
import ladder.domain.LadderFactory;
import ladder.ui.Input;
import ladder.ui.Output;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderFactoryTest {

    @Test
    public void ladderFactoryTest() {

        Input input = WhenUtils.input("a,b,c", 5);
        Output output = WhenUtils.output();

        assertThat(LadderFactory.of(new LadderDataInput(input, output)))
            .isInstanceOf(Ladder.class);
    }
}
