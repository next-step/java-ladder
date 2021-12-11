package domain;

import static common.Constants.MIN_LADDER_HEIGHT;
import static common.ErrorMessages.LADDER_HEIGHT_IS_TOO_SHORT;

public class Height {

  private int height;

  public Height(int height) {
    checkValidity(height);
    this.height = height;
  }

  private void checkValidity(int height) {
    if(height < MIN_LADDER_HEIGHT) {
      throw new IllegalArgumentException(LADDER_HEIGHT_IS_TOO_SHORT);
    }
  }

  public int getValue() {
    return this.height;
  }

}
