package ladder.service;

import ladder.domain.Bridge;
import ladder.domain.ConnectionStrategy;
import ladder.domain.Ladder;
import ladder.domain.LadderSetting;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final Ladder ladder = new Ladder();
    private Map<String, String> participantOutcomes;

    public LadderGame() {
    }

    public List<Bridge> createLadder(LadderSetting setting, ConnectionStrategy strategy) {
        return ladder.createSteps(setting, strategy);
    }

    public void playGame(String[] participantNames, String[] outcomes) {
        participantOutcomes = ladder.findOutcomeForParticipant(participantNames, outcomes);
    }

    public String getOutcomeForParticipant(String participantNameForOutcome) {
        if (participantNameForOutcome.equals("all")) {
            return participantOutcomes.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + " : " + entry.getValue())
                    .collect(Collectors.joining("\n"));
        }

        if (participantOutcomes.get(participantNameForOutcome) == null) {
            throw new NullPointerException("존재하지 않는 참가자입니다.");
        }

        return participantOutcomes.get(participantNameForOutcome);
    }

    public Map<String, String> getParticipantOutcomes() {
        return participantOutcomes;
    }

}
