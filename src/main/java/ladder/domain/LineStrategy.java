package ladder.domain;

import java.util.List;

public interface LineStrategy {
    List<Boolean> initialPoints(int countOfParticipants);
}
