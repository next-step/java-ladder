package ladderGame.step4.service;

import ladderGame.step4.validation.Validation;
import ladderGame.step4.view.InputView;

public class Creator {

  public static String getPlayerNames() {
    String playerNames = InputView.inputUserNames();
    Validation.validationNames(playerNames);
    return playerNames;
  }

  public static String getGoods(final String playerNames) {
    String goods = InputView.inputGoods();
    Validation.validationNamesAndGoodsCount(playerNames, goods);
    return goods;
  }

  public static int getHeight() {
    int ladderHeight = InputView.inputLadderHeight();
    Validation.validationLimitHeight(ladderHeight);
    return ladderHeight;
  }

}