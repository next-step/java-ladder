package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.NoEqualLengthArgumentException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String NO_EQUAL_LENGTH_ERROR_MESSAGE =
            "참가자 수와 경품 수가 맞아야 한다.";
    private Ladder ladder;
    private Participants participants;
    private Prizes prizes;

    public static LadderGame valueOf(List<String> names,
                                     List<String> prizes,
                                     Ladder ladder) {
        if (names.size() != prizes.size()) {
            throw new NoEqualLengthArgumentException(NO_EQUAL_LENGTH_ERROR_MESSAGE);
        }

        return new LadderGame(new Participants(names), new Prizes(prizes),
                ladder);
    }

    private LadderGame(Participants participants, Prizes prizes,
                       Ladder ladder) {
        this.participants = participants;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public int getLadderSize() {
        return ladder.size();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prize prize(String participantName) {
        int index = participants.indexOf(new Participant(participantName));
        int prizeIndex = ladder.result(index);
        return prizes.get(prizeIndex);
    }

    public Map<Participant, Prize> prizeAll() {
        Map<Participant, Prize> results = new HashMap<>();
        for (int i = 0, width = participants.size(); i < width; i++) {
            int prizeIndex = ladder.result(i);
            results.put(participants.get(i), prizes.get(prizeIndex));
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
