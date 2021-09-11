package ladder.domain.ladder;

import java.util.List;

public interface LadderLineGenerator {
    List<Boolean> generate(final int maxLadderWidth);
}
