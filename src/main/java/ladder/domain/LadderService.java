package ladder.domain;

import ladder.domain.model.LadderLines;

public interface LadderService {
    LadderLines createLadderLines(int size, int height);
}
