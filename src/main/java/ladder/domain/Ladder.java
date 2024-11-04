package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Bridge> steps;

    public Ladder() {
        steps = new ArrayList<>();
    }

    public Ladder createSteps(LadderSetting setting, ConnectionStrategy strategy) {
        IntStream.range(0, setting.getLadderHeight())
                .forEach(index -> {
                    Bridge bridge = new Bridge();
                    bridge.connectSteps(setting.getLadderCount(), strategy);
                    steps.add(bridge);
                });

        return this;
    }

    public LadderResult findOutcomeForParticipant(LadderGameData gameData) {
        LadderResult ladderResult = new LadderResult();

        Map<String, String> participantOutcomes = ladderResult.getParticipantOutcomes();
        String[] participantNames = gameData.getParticipantNames();
        String[] outcomes = gameData.getOutcomes();

        if(participantNames.length != outcomes.length) {
            throw new RuntimeException("참가자의 수와 사다리 결과 개수가 일치하지 않습니다.");
        }

        for (int index = 0; index < participantNames.length; index++) {
            Position startPosition = new Position(index);
            Position finalPosition = traverseLadder(startPosition);
            participantOutcomes.put(participantNames[index], getOutcome(finalPosition, outcomes));
        }

        return ladderResult;
    }

    private Position traverseLadder(Position position) {
        for (Bridge bridge : steps) {
            position = bridge.move(position);
        }
        return position;
    }

    private String getOutcome(Position finalPosition, String[] outcomes) {
        return outcomes[finalPosition.getValue()];
    }

    public List<Bridge> getSteps() {
        return steps;
    }

}
