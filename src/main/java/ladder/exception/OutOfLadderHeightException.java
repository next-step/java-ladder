package ladder.exception;

public class OutOfLadderHeightException extends IllegalArgumentException {

  public OutOfLadderHeightException() {
    super("입력한 사다리의 높이가 너무 높습니다");
  }
}
