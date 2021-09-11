package ladder.domain.game;

import ladder.domain.position.Position;
import ladder.domain.name.PrizeName;
import ladder.domain.participant.Participant;

public class LadderPrize {
    private final PrizeName prizeName;
    private final Position position;

    LadderPrize(String prizeName, Position position) {
        this.prizeName = new PrizeName(prizeName);
        this.position = position;
    }

    boolean matchPrize(Participant participant) {
        return participant.hasEqualPosition(position);
    }

    public static String getName(LadderPrize ladderPrize) {
        return ladderPrize.prizeName.toString();
    }
}
