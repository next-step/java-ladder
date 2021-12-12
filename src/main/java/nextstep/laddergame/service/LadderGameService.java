package nextstep.laddergame.service;

import java.util.List;
import java.util.stream.IntStream;

import nextstep.laddergame.model.Goal;
import nextstep.laddergame.model.Ladder;
import nextstep.laddergame.model.Participant;
import nextstep.laddergame.model.Results;

public class LadderGameService {

    public Results play(List<Participant> participants, Ladder ladder, List<Goal> goals) {
        Results results = new Results();
        IntStream.range(0, participants.size())
                 .forEach(position -> results.add(participants.get(position), goals.get(ladder.moveDown(position))));
        return results;
    }
}
