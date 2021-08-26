package ladderGame.step4.validation;

public class Validation {

  private static final String SPLIT_MARK = ",";
  private static final int LIMIT_HEIGHT = 1;
  private static final String MSG_ERROR_LIMIT_HEIGHT = "사다리높이는 1이상부터 가능합니다.";
  private static final String MSG_ERROR_INCORRECT_COUNT = "사용자 수와 결과의 수가 일치하지 않습니다.";
  private static final String MSG_ERROR_NO_PLAYERS = "사용자를 2명 이상 입력하세요.";
  private static final int LIMIT_PLAYER_COUNT = 2;

  public static void validationNames(final String usersName) {
    if (usersName.split(SPLIT_MARK).length < LIMIT_PLAYER_COUNT) {
      throw new IllegalArgumentException(MSG_ERROR_NO_PLAYERS);
    }
  }

  public static void validationNamesAndGoodsCount(final String usersName, final String goods) {

    validationPrizes(goods);

    if (usersName.split(SPLIT_MARK).length != goods.split(SPLIT_MARK).length) {
      throw new IllegalArgumentException(MSG_ERROR_INCORRECT_COUNT);
    }
  }

  private static void validationPrizes(final String goods) {
    if (goods.split(SPLIT_MARK).length < LIMIT_PLAYER_COUNT) {
      throw new IllegalArgumentException("상품을 2개 이상 입력하세요.");
    }
  }

  public static void validationLimitHeight(final int ladderHeight) {
    if (ladderHeight < LIMIT_HEIGHT) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_HEIGHT);
    }
  }

}
