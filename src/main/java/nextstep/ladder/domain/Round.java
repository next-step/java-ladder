package nextstep.ladder.domain;

public class Round {

    private final Heights heights;

    private Round(Heights heights) {
        this.heights = heights;
    }

    public static Round valueOf(Heights heights) {
        return new Round(heights);
    }

    public void startRadder(Participants participants) {
        heights.countDown();

    }

    public boolean hasMoreRound() {
        return heights.isOverMinimum();
    }
}
