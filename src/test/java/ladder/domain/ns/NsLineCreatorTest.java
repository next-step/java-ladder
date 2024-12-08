package ladder.domain.ns;

import ladder.domain.engine.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NsLineCreatorTest {
    @Test
    void create() {
        NsLineCreator nsLineCreator = new NsLineCreator();

        Line line = nsLineCreator.create(4);
        int actual = line.getPoints().size();

        Assertions.assertThat(actual).isEqualTo(4);
    }
}
