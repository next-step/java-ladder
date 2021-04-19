package ladder.model.result;

public class InterimResult {
  private final int firstIndex;
  private int resultIndex;

  public InterimResult(int firstIndex, int resultIndex) {
    this.firstIndex = firstIndex;
    this.resultIndex = resultIndex;
  }

  public int firstIndex() {
    return firstIndex;
  }

  public int resultIndex() {
    return resultIndex;
  }

  public void move(int movingCursor) {
    resultIndex += movingCursor;
  }

}
