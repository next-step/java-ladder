package nextstep.ladder.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private final GameEntities gameEntities;
    private final Ladder ladder;

    public LadderGame(GameEntities gameEntities, Ladder ladder) {
        this.gameEntities = gameEntities;
        this.ladder = ladder;
    }

    public Reward findRewardByParticipantName(String participantName) {
        int participantPosition = gameEntities.findParticipantPositionByParticipantName(participantName);
        int rewardPosition = ladder.findEndPosition(participantPosition);
        return gameEntities.findRewardByPosition(rewardPosition);
    }

    public Map<Participant, Reward> findAllResult() {
        return gameEntities.getParticipants()
                .stream()
                .collect(Collectors.toMap(
                        participant -> participant,
                        participant -> findRewardByParticipantName(participant.getName())
                ));
    }
}
