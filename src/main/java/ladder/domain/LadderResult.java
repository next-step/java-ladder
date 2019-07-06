package ladder.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private final Map<Integer, Integer> positionGoals;

    private LadderResult(Map<Integer, Integer> positionGoals) {

        this.positionGoals = positionGoals;
    }

    public static LadderResult of(LadderGame ladderGame) {

        Map<Integer, Integer> positionGoals = new HashMap<>();
        for (int i = 0; i < ladderGame.getGameInfo().getParticipants().size(); i++) {
            positionGoals.put(i, ladderGame.getLines().move(i));
        }

        return new LadderResult(positionGoals);
    }

    public ParticipantGoals createParticipantGoal(GameInfo gameInfo) {

        return new ParticipantGoals(
                positionGoals.entrySet()
                        .stream()
                        .map(entrySet -> new ParticipantGoal(gameInfo.getParticipants().getParticipant(entrySet.getKey()), gameInfo.getGoals().getGoal(entrySet.getValue())))
                        .collect(Collectors.toList()));
    }
}
