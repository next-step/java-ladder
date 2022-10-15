package ladder.domain.line.v1;

import ladder.domain.line.ILine;
import ladder.domain.line.LineFactory;
import ladder.external.RandomFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLineFactoryTest {

    @Test
    void create() {
        RandomFactory alwaysTrueRandomFactory = new RandomFactory() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
        LineFactory randomLineFactory = new RandomLineFactory(alwaysTrueRandomFactory);
        ILine line = randomLineFactory.create(6);

        assertThat(line).isEqualTo(new Line(List.of(true, false, true, false, true)));
    }
}
