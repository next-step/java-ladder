package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public GameResult play(List<String> results) {
        int participantCount = participants.getParticipantCount();
        Map<String, String> resultsMap = new LinkedHashMap<>();
        for (int nth = 0; nth < participantCount; nth++) {
            int resultOrder = ladder.moveDown(nth);
            resultsMap.put(participants.findNameByOrder(nth), results.get(resultOrder));
        }
        return new GameResult(resultsMap);
    }
}
