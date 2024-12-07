package ladder.domain.ns;

import ladder.domain.engine.Line;
import ladder.domain.engine.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NsLinesCreatorTest {
    public static final String POBI_HONUX_CRONG_JK = "pobi,honux,crong,jk";
    @Test
    void create() {
        NsLineCreator nsLineCreator = new NsLineCreator();
        NsLinesCreator nsLinesCreator = new NsLinesCreator(nsLineCreator);
        int verticalSize = 5;

        List<Line> lines = nsLinesCreator.create(new Players(POBI_HONUX_CRONG_JK), verticalSize)
                .getLines();
        int actual = lines.size();

        assertThat(actual).isEqualTo(verticalSize);
    }
}
