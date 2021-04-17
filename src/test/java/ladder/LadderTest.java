package ladder;

import ladder.domain.Ladder;
import ladder.domain.Layer;
import ladder.service.RandomBoolean;
import ladder.service.RandomBooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LadderTest {
    public final RandomBoolean randomTrueBoolean = new RandomBooleanGenerator() {
        @Override
        public boolean randomBoolean() {
            return true;
        }
    };


    @Test
    public void Ladder() {
        // given
        final int line = 6;
        final int height = 3;
        Layer trueLayer = new Layer(line, randomTrueBoolean);
        Ladder expectLadder = new Ladder(Arrays.asList(trueLayer, trueLayer, trueLayer));

        // when
        Ladder resultLadder = new Ladder(line, height, randomTrueBoolean);
        
        // then
        Assertions.assertThat(resultLadder).isEqualTo(expectLadder);
    }
}
