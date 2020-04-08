package ladder.model.prize;

public class LadderPrize {
    private PrizeName prizeName;

    public LadderPrize(String prizeName) {
        this.prizeName = new PrizeName(prizeName);
    }

    public PrizeName getPrizeName() {
        return prizeName;
    }
}
