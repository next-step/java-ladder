package ladder.domain;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import ladder.strategy.LinkStrategy;

public class Ladder {

    private final static String ERROR_ZERO_OR_NEGATIVE_VALUE = "0보다 큰 값만 입력 가능합니다.";

    private final Participants participants;
    private final Lines lines;
    private final Prizes prizes;

    public Ladder(final String participants, final int height, final String prizes) {
        validateHeight(height);
        this.participants = new Participants(participants);
        this.lines = new Lines(height, this.participants.size());
        this.prizes = new Prizes(prizes, this.participants.size());
    }

    private void validateHeight(final int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ERROR_ZERO_OR_NEGATIVE_VALUE);
        }
    }

    public void draw(final LinkStrategy strategy) {
        lines.draw(strategy);
    }

    public Map<Name, Prize> play() {
        Map<Name, Prize> result = new HashMap<>();
        List<Name> names = participants.getNames();
        IntStream.range(0, names.size()).forEach(i -> {
            Name participant = names.get(i);
            Prize prize = move(i);
            result.put(participant, prize);
        });

        return result;
    }

    private Prize move(final int startColumnNumber) {
        return getPrizes().get(lines.move(startColumnNumber));
    }

    public List<Name> getParticipants() {
        return participants.getNames();
    }

    public List<Line> getLines() {
        return lines.getValue();
    }

    public List<Prize> getPrizes() {
        return prizes.getValue();
    }
}
