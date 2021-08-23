package ladderGame.step4.validation;

public class Validation {

  public static final String SPLIT_MARK = ",";
  public static final int LIMIT_HEIGHT = 1;
  public static final String MSG_ERROR_LIMIT_HEIGHT = "사다리높이는 1이상부터 가능합니다.";
  public static final String MSG_ERROR_INCORRECT_COUNT = "사용자 수와 결과의 수가 일치하지 않습니다.";

  public static void validationLimitHeight(final int ladderHeight) {
    if (ladderHeight < LIMIT_HEIGHT) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_HEIGHT);
    }
  }

  public static void validationNamesAndGoodsCount(final String usersName, final String goods) {
    if (usersName.split(SPLIT_MARK).length != goods.split(SPLIT_MARK).length) {
      throw new IllegalArgumentException(MSG_ERROR_INCORRECT_COUNT);
    }
  }
}
