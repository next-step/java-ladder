package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private final Map<Integer, Integer> positionGoals;

    public LadderResult(Map<Integer, Integer> positionGoals) {

        this.positionGoals = positionGoals;
    }

    public static LadderResult of(Ladder ladder) {

        Map<Integer, Integer> positionGoals = new HashMap<>();
        for (int i = 0; i < ladder.getLadderInfo().getWidth(); i++) {
            positionGoals.put(i, ladder.getLines().move(i));
        }

        return new LadderResult(positionGoals);
    }

    public ParticipantGoals createParticipantGoal(Participants participants, Goals goals) {

        return new ParticipantGoals(
                positionGoals.entrySet()
                        .stream()
                        .collect(Collectors.toMap(o -> participants.getParticipant(o.getKey()),
                                                  o -> goals.getGoal(o.getValue()),
                                                  (o1, o2) -> o1
                        )));
    }
}
