package ladder.service;

import ladder.domain.Ladder;
import ladder.domain.Participants;
import ladder.domain.Results;

import java.util.HashMap;
import java.util.Map;

public class LadderService {
    public static int moveResultPosition(Participants participants, Ladder ladder, String selectedPerson) {
        int positionOfPerson = participants.findPosition(selectedPerson);

        return ladder.move(positionOfPerson);
    }

    public static String getResultName(Results results, int moveResultPosition) {
        return results.getResultName(moveResultPosition);
    }

    public static Map<String, String> moveAllResultsPosition(Participants participants, Ladder ladder, Results results) {
        Map<String, String> allResults = new HashMap<>();

        for (int index = 0; index < participants.countOfParticipants(); index++) {
            String resultName = getResultName(results, ladder.move(index));
            allResults.put(participants.getNameOfPerson(index), resultName);
        }

        return allResults;
    }

}
