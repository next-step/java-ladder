package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static final String PARTICIPANTS_RESULTS_COUNT_ERROR = "실행 결과를 참가자의 수만큼 입력해주세요.";
    private List<Participant> participants;
    private LadderResults ladderResults;
    private Ladder ladder;

    public LadderGame(List<Participant> participants, LadderResults ladderResults) {
        assertParticipantAndResultCount(participants, ladderResults);
    }

    public LadderGame(List<Participant> participants, Ladder ladder) {
        this.participants = participants;
        this.ladder = ladder;
    }

    public List<GameResult> play() {
        List<GameResult> gameResults = new ArrayList<>();

        for(Participant participant : participants) {
            int finalPosition = ladder.move(participant.getPosition());
            gameResults.add(new GameResult(participant, ladderResults.getByPosition(finalPosition)));
        }

        return gameResults;
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

}
