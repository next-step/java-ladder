package nextstep.laddergame.service;

import java.util.List;
import java.util.stream.IntStream;

import nextstep.laddergame.model.Goal;
import nextstep.laddergame.model.Ladder;
import nextstep.laddergame.model.Participant;
import nextstep.laddergame.model.Position;
import nextstep.laddergame.model.Result;
import nextstep.laddergame.model.Results;

public class LadderGameService {

    public Results play(List<Participant> participants, Ladder ladder, List<Goal> goals) {
        Results results = new Results();
        IntStream.range(0, participants.size())
                 .mapToObj(number -> eachPlay(number, participants.get(number), ladder, goals))
                 .forEach(result -> results.add(result.getParticipant(), result.getGoal()));
        return results;
    }

    private Result eachPlay(int number, Participant participant, Ladder ladder, List<Goal> goals) {
        Position position = new Position(number);
        ladder.moveDown(position);
        return new Result(participant, goals.get(position.getCursur()));
    }
}
