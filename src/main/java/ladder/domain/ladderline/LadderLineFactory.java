package ladder.domain.ladderline;

import ladder.domain.model.LadderLines;

@FunctionalInterface
public interface LadderLineFactory {
    LadderLines create(int size, int height);
}
