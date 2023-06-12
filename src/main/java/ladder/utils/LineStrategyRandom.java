package ladder.utils;


import java.util.Random;

public class LineStrategyRandom implements LineStrategy {

  private static final int LADDER_COLUMN_CLAMP_SIZE = 1;

  private final int columnLimit;
  private final int rowLimit;

  private final Random random;

  private LineStrategyRandom(int columnLimit, int rowLimit) {
    this.columnLimit = columnLimit - LADDER_COLUMN_CLAMP_SIZE;
    this.rowLimit = rowLimit;
    this.random = new Random();
  }

  public static LineStrategy ofLimit(int columnLimit, int rowLimit) {
    return new LineStrategyRandom(columnLimit, rowLimit);
  }

  @Override
  public int anyRow() {
    return random.nextInt(rowLimit);
  }

  @Override
  public int anyColumn() {
    return random.nextInt(columnLimit);
  }
}
