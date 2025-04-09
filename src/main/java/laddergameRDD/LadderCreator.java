package laddergameRDD;

public interface LadderCreator {
    public Ladder createLadder(int rowCount, int columnCount, SelectStrategy selectStrategy);
}
