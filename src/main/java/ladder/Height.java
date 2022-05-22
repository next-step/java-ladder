package ladder;

public class Height {

  public static final String MESSAGE_FOR_INVALID_HEIGHT = "사다리 높이는 %s이상 이어야합니다.";
  public static final int MIN_HEIGHT = 1;

  private final int height;

  public Height(int height) {
    validateHeight(height);
    this.height = height;
  }

  public boolean isMoreThan(int number) {
    return height > number;
  }

  private void validateHeight(int height) {
    if (height < MIN_HEIGHT) {
      throw new IllegalArgumentException(String.format(MESSAGE_FOR_INVALID_HEIGHT, MIN_HEIGHT));
    }
  }
}
