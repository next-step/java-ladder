package ladder.model;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGameResult {
    public static final String NO_MATCHING_PRIZE = "해당 참가자에 매칭되는 결과가 없습니다.";

    private final Map<Participant, Prize> ladderGameResult;

    private LadderGameResult(Map<Participant, Prize> ladderGameResult) {
        this.ladderGameResult = ladderGameResult;
    }

    public static LadderGameResult generateLadderGameResult(Ladder ladder, Participants participants, Prizes prizes) {
        Map<Participant, Prize> result = participants.getParticipants().stream()
                .collect(Collectors.toMap(
                        participant -> participant,
                        participant -> prizes.getPrizeAt(getLastPositionOf(ladder, participant))
                ));

        return new LadderGameResult(result);
    }

    private static int getLastPositionOf(Ladder ladder, Participant participant) {
        return ladder.getLastPositionAt(participant.getStartPoint());
    }

    public String getPrizeOf(Participant participant) {
        if (!ladderGameResult.containsKey(participant)) {
            throw new IllegalArgumentException(NO_MATCHING_PRIZE);
        }

        return ladderGameResult.get(participant).getPrizeName();
    }

}
