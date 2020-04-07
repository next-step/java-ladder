package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    public static final String PARTICIPANTS_RESULTS_COUNT_ERROR = "실행 결과를 참가자의 수만큼 입력해주세요.";
    private List<Participant> participants;
    private LadderResults ladderResults;
    private Ladder ladder;

    public LadderGame(List<Participant> participants, LadderResults ladderResults) {
        assertParticipantAndResultCount(participants, ladderResults);
    }

    public LadderGame(List<Participant> participants, Ladder ladder, LadderResults ladderResults) {
        assertParticipantAndResultCount(participants, ladderResults);

        this.participants = participants;
        this.ladder = ladder;
    }

    public GameResults play() {
        Map<String, String> gameResults = new HashMap<>();

        for(Participant participant : participants) {
            int finalPosition = ladder.move(participant.getPosition());
            gameResults.put(participant.getName(), ladderResults.getByPosition(finalPosition));
        }

        return new GameResults(gameResults);
    }

    private void assertParticipantAndResultCount(List<Participant> participants, LadderResults ladderResults) {
        if(participants.size() != ladderResults.getSize()) {
            throw new IllegalArgumentException(PARTICIPANTS_RESULTS_COUNT_ERROR);
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }

}
