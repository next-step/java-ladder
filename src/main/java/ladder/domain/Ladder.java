package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Bridge> steps;

    public Ladder() {
        steps = new ArrayList<>();
    }

    public List<Bridge> createSteps(LadderSetting setting, ConnectionStrategy strategy) {
        return IntStream.range(0, setting.getLadderHeight())
                .mapToObj(index -> {
                    Bridge bridge = new Bridge();
                    bridge.connectSteps(setting.getLadderCount(), strategy);
                    steps.add(bridge);
                    return bridge;
                })
                .collect(Collectors.toList());
    }

    public Map<String, String> findOutcomeForParticipant(String[] participantNames, String[] outcomes) {
        Map<String, String> participantOutcomes = new LinkedHashMap<>();

        for (int index = 0; index < participantNames.length; index++) {
            int startPosition = index;
            int finalPosition = traverseLadder(startPosition);
            participantOutcomes.put(participantNames[index], getOutcome(finalPosition, outcomes));
        }

        return participantOutcomes;
    }

    private int traverseLadder(int startPosition) {
        int position = startPosition;

        for (Bridge bridge : steps) {
            position = bridge.move(position);
        }
        return position;
    }

    private String getOutcome(int finalPosition, String[] outcomes) {
        return outcomes[finalPosition];
    }

}
