package ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private final Map<Integer, Integer> positionGoals;

    public LadderResult(Map<Integer, Integer> positionGoals) {

        this.positionGoals = positionGoals;
    }

    public ParticipantGoals createParticipantGoal(GameInfo gameInfo) {

        return new ParticipantGoals(
                positionGoals.entrySet()
                        .stream()
                        .map(entrySet -> new ParticipantGoal(gameInfo.getParticipants().getParticipant(entrySet.getKey()), gameInfo.getGoals().getGoal(entrySet.getValue())))
                        .collect(Collectors.toList()));
    }
}
