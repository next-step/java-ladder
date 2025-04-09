package laddergameRDD;

public class RandomLadderCreator implements LadderCreator {
    @Override
    public Ladder createLadder(int rowCount, int columnCount, SelectStrategy selectStrategy) {
        return new Ladder(rowCount, columnCount, new RandomSelectStrategy());
    }
}
