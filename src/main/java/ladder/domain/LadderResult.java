package ladder.domain;

import ladder.GameInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private final Map<Integer, Integer> positionGoals;

    private LadderResult(Map<Integer, Integer> positionGoals) {

        this.positionGoals = positionGoals;
    }

    public static LadderResult of(Ladder ladder) {

        Map<Integer, Integer> positionGoals = new HashMap<>();
        for (int i = 0; i < ladder.getLadderInfo().getWidth(); i++) {
            positionGoals.put(i, ladder.getLines().move(i));
        }

        return new LadderResult(positionGoals);
    }

    public ParticipantGoals createParticipantGoal(GameInfo gameInfo) {

        return new ParticipantGoals(
                positionGoals.entrySet()
                        .stream()
                        .collect(Collectors.toMap(o -> gameInfo.getParticipants().getParticipant(o.getKey()),
                                                  o -> gameInfo.getGoals().getGoal(o.getValue()),
                                                  (o1, o2) -> o1
                        )));
    }
}
