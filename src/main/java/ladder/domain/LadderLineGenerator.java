package ladder.domain;

import java.util.List;

public interface LadderLineGenerator {
    List<Boolean> generate(int countOfParticipants);
}
