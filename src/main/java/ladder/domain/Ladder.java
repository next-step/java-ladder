package ladder.domain;

public class Ladder {

    private LadderNumber ladderNumber;

    private Prize prize;

    public Ladder(int ladderNumber, String prize) {
        this(new LadderNumber(ladderNumber), new Prize(prize));
    }

    public Ladder(LadderNumber ladderNumber, Prize prize) {
        this.ladderNumber = ladderNumber;
        this.prize = prize;
    }

    public boolean isMatch(LadderNumber ladderNumberToCompare) {
        return ladderNumber.equals(ladderNumberToCompare);
    }

    public Prize prize() {
        return prize;
    }
}
