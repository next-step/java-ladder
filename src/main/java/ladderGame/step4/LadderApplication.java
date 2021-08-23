package ladderGame.step4;

import static ladderGame.step4.validation.Validation.validationLimitHeight;
import static ladderGame.step4.validation.Validation.validationNamesAndGoodsCount;

import ladderGame.step4.controller.LadderMainController;
import ladderGame.step4.model.Ladder;
import ladderGame.step4.model.Players;
import ladderGame.step4.model.Prizes;
import ladderGame.step4.view.InputView;

public class LadderApplication {


  public static void main(String[] args) {

    String playerNames = InputView.inputUserNames();
    String goods = InputView.inputGoods();

    validationNamesAndGoodsCount(playerNames, goods);

    Players players = new Players(Players.of(playerNames));

    int ladderHeight = InputView.inputLadderHeight();
    validationLimitHeight(ladderHeight);
    Ladder ladder = new Ladder(Ladder.of(ladderHeight, players.count()));

    Prizes prizes = new Prizes(Prizes.createPrizes(goods, players.count()));
    LadderMainController.findLadderInfo(players, ladder, prizes);
  }

}