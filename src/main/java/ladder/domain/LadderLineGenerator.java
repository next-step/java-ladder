package ladder.domain;

import java.util.List;

public interface LadderLineGenerator {
    List<Boolean> generate(final int maxLadderWidth);
}
