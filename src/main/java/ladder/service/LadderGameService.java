package ladder.service;

import ladder.domain.MatchingItems;
import ladder.domain.Ladder;
import ladder.domain.Participants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGameService {

    public List<String> executeGame(Participants participants, Ladder ladder, MatchingItems matchingItems) {
        List<String> gameResultList = new ArrayList<>();
        for (int entranceNumber = Participants.MIN_ENTRANCE_NUMBER; entranceNumber < participants.getCount(); entranceNumber++) {
            gameResultList.add(matchingItems.getGameResult(ladder.getExitNumber(entranceNumber)));
        }
        return Collections.unmodifiableList(gameResultList);
    }
}