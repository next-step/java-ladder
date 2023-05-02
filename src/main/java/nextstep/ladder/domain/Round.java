package nextstep.ladder.domain;

public class Round {

    private final Heights heights;

    private Round(Heights heights) {
        this.heights = heights;
    }

    public static Round valueOf(Heights heights) {
        return new Round(heights);
    }

    public Lines drawLadder(Participants participants, DrawStrategy drawStrategy) {
        heights.countDown();
        return Lines.init(participants, drawStrategy);
    }

    public boolean hasMoreRound() {
        return heights.isOverMinimum();
    }
}
