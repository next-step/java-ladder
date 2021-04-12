package ladder.service;

import ladder.domain.GameResults;
import ladder.domain.Ladder;
import ladder.domain.Participants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGameService {

    public String inquiryGameResult(Participants participants, Ladder ladder, GameResults gameResults, String inquiryTargetName) {
        int entranceNumber = participants.getEntranceNumber(inquiryTargetName);
        int exitNumber = ladder.getExitNumber(entranceNumber);
        return gameResults.getGameResult(exitNumber);
    }

    public List<String> inquiryGameResults(Participants participants, Ladder ladder, GameResults gameResults) {
        List<String> gameResultList = new ArrayList<>();
        for (int entranceNumber = Participants.MIN_ENTRANCE_NUMBER; entranceNumber < participants.getCount(); entranceNumber++) {
            gameResultList.add(gameResults.getGameResult(ladder.getExitNumber(entranceNumber)));
        }
        return Collections.unmodifiableList(gameResultList);
    }
}