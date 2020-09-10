package ladder.domain;

import org.junit.jupiter.api.Test;

import ladder.WhenUtils;
import ladder.ui.Input;
import ladder.ui.LadderDataInput;
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
