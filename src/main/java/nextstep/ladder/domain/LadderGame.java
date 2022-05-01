package nextstep.ladder.domain;

import java.util.stream.IntStream;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;

    public LadderGame(Participants participants, Ladder ladder) {
        validateSize(participants, ladder);
        this.participants = participants;
        this.ladder = ladder;
    }

    private void validateSize(Participants participants, Ladder ladder) {
        if (participants.size() != ladder.getWidth()) {
            throw new IllegalArgumentException("number of participants must be equal with ladder width");
        }
    }

    public void play() {
        ladder.apply(participants);
    }

    public LadderGameResult match(Prizes prizes) {
        if (prizes.size() != participants.size()) {
            throw new IllegalArgumentException("number of prizes must be equal with number of participants");
        }
        LadderGameResult result = new LadderGameResult();
        IntStream.range(0, prizes.size())
                .forEach(index -> result.put(participants.get(index), prizes.get(index)));
        return result;
    }
}
