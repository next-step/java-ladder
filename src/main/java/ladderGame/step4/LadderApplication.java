package ladderGame.step4;

import ladderGame.step4.controller.LadderMainController;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;
import ladderGame.step4.view.InputView;

public class LadderApplication {

  public static final String SPLIT_MARK = ",";
  public static final int LIMIT_HEIGHT = 1;
  public static final String MSG_ERROR_LIMIT_HEIGHT = "사다리높이는 1이상부터 가능합니다.";
  public static final String MSG_ERROR_INCORRECT_COUNT = "사용자 수와 결과의 수가 일치하지 않습니다.";

  public static void main(String[] args) {

    String inputNames = InputView.inputUserNames();
    String goods = InputView.inputGoods();

    validationNamesAndGoodsCount(inputNames, goods);

    Players players = new Players(Players.of(inputNames));

    int ladderHeight = InputView.inputLadderHeight();
    validationLimitHeight(ladderHeight);
    Ladder ladder = new Ladder(Ladder.of(ladderHeight, players.count()));

    Prizes prizes = new Prizes(Prizes.createPrizes(goods, players.count()));
    LadderMainController.findLadderInfo(players, ladder, prizes);
  }

  private static void validationLimitHeight(final int ladderHeight) {
    if (ladderHeight < LIMIT_HEIGHT) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_HEIGHT);
    }
  }

  private static void validationNamesAndGoodsCount(final String usersName, final String goods) {
    if (usersName.split(SPLIT_MARK).length != goods.split(SPLIT_MARK).length) {
      throw new IllegalArgumentException(MSG_ERROR_INCORRECT_COUNT);
    }
  }
}