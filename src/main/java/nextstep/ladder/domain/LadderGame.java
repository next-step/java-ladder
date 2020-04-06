package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.NoEqualLengthArgumentException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String NO_EQUAL_LENGTH_ERROR_MESSAGE =
            "참가자 수와 경품 수가 맞지 않습니다.";
    private Ladder ladder;
    private Participants participants;
    private Prizes prizes;

    public LadderGame(List<String> names, List<String> prizes, Ladder ladder) {
        if (names.size() != prizes.size()) {
            throw new NoEqualLengthArgumentException(
                    NO_EQUAL_LENGTH_ERROR_MESSAGE);
        }
        this.participants = new Participants(names);
        this.prizes = new Prizes(prizes);
        this.ladder = ladder;
    }

    public int getLadderHeight() {
        return ladder.height();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderGameResult result(String participantName) {
        Participant participant = new Participant(participantName);
        int index = participants.indexOf(participant);
        int prizeIndex = ladder.result(index);
        return new LadderGameResult(participant, prizes.get(prizeIndex));
    }

    public List<LadderGameResult> resultAll() {
        List<LadderGameResult> results = new ArrayList<>();
        for (int i = 0, width = participants.size(); i < width; i++) {
            int prizeIndex = ladder.result(i);
            results.add(new LadderGameResult(participants.get(i),
                    prizes.get(prizeIndex)));
        }

        return results;
    }

    public List<String> getParticipantNames() {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }

    public List<String> getPrizeNames() {
        return prizes.stream()
                .map(Prize::getName)
                .collect(Collectors.toList());
    }
}
