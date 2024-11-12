package nextstep.laddergame.domain;

import java.util.List;

public class LadderGame {
    private final List<String> participants;
    private final Integer maxHeight;
    private final Ladders ladders;

    private LadderGame(List<String> participants, Integer maxHeight, Ladders ladders) {
        this.participants = participants;
        this.maxHeight = maxHeight;
        this.ladders = ladders;
    }

    public LadderGame(List<String> participants, Integer maxHeight) {
        this(participants, maxHeight, Ladders.create(participants.size(), maxHeight, new RandomLadderLinesGenerator()));
    }

    public List<String> getParticipants() {
        return participants;
    }

    public Integer getMaxHeight() {
        return maxHeight;
    }

    public Ladders getLadders() {
        return ladders;
    }

    public int getLaddersSize() {
        return ladders.size();
    }
}
