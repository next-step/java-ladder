package domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private final HeadAndTail headAndTail;
    private final Ladder ladder;

    private LadderGame(final HeadAndTail headAndTail, final Ladder ladder) {
        this.headAndTail = headAndTail;
        this.ladder = ladder;
    }

    public static LadderGame init(final HeadAndTail headAndTail, final Ladder ladder) {
        return new LadderGame(headAndTail, ladder);
    }

    public Map<String, String> fetchAllResults() {

        int numberOfPeople = headAndTail.getParticipants().size();

        Map<String, String> allResults = new HashMap<>();

        for(int i = 0; i < numberOfPeople; i++) {
            allResults.put( headAndTail.getParticipants().get(i), headAndTail.getRewardAt(ladder.move(i)) );
        }

        return allResults;
    }

    public HeadAndTail getHeadAndTail() {
        return headAndTail;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
