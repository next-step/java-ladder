package ladder.domain;

public class Ladder {
    private LadderHeight height;

    private Integer maxLineCountEachRow;

    public Ladder(LadderHeight height, Integer maxLineCountEachRow) {
        this.height = height;
        this.maxLineCountEachRow = maxLineCountEachRow;
    }

    public static Ladder create(Integer height, Players players) {
        LadderHeight ladderHeight = new LadderHeight(height);
        return new Ladder(ladderHeight, players.count() - 1);
    }

    public LadderHeight getHeight() {
        return height;
    }

    public Integer getMaxLineCountEachRow() {
        return maxLineCountEachRow;
    }
}
