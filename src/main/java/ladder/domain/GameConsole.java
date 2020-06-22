package ladder.domain;

import ladder.domain.ladder.Ladder;
import ladder.domain.participants.Participants;
import ladder.domain.participants.Person;
import ladder.domain.result.GameResult;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameConsole {
    private Participants participants;
    private Ladder ladder;

    private GameConsole(Participants participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public static GameConsole valueOf(Participants participants, Ladder ladder) {
        return new GameConsole(participants, ladder);
    }


    public GameResult runLadder(Results results) {
        Map<Person, Result> gameResult = new LinkedHashMap<>();
        int personIndex = 0;
        for (Person person : participants.getParticipants()) {
            int position = ladder.run(personIndex);
            Result result = results.find(position);
            gameResult.put(person, result);
            personIndex++;
        }
        return GameResult.valueOf(gameResult);
    }

}
