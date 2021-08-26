package ladderGame.step4;

import ladderGame.step4.controller.LadderMainController;
import ladderGame.step4.dto.CreatorDto;
import ladderGame.step4.dto.ModelDto;
import ladderGame.step4.service.Creator;
import ladderGame.step4.view.InputView;
import ladderGame.step4.view.ResultView;

public class LadderApplication {

  public static final String ALL_NAMES = "all";

  public static void main(String[] args) {

    LadderMainController ladderMainController = new LadderMainController();

    String playerNames = Creator.getPlayerNames();
    String goods = Creator.getGoods(playerNames);
    int ladderHeight = Creator.getHeight();

    ModelDto modelDto = ladderMainController.create(
        new CreatorDto(playerNames, goods, ladderHeight));

    ResultView.printUsersName(modelDto.getPlayers().playersName());
    ResultView.printLadder(modelDto.getLadder());
    ResultView.printPrizes(modelDto.getPrizes());

    String findName = getFindNameWithResult(ladderMainController, modelDto);

    while (!isContinue(findName)) {
      findName = getFindNameWithResult(ladderMainController, modelDto);
    }
  }

  private static String getFindNameWithResult(final LadderMainController ladderMainController,
      final ModelDto modelDto) {
    String findName = InputView.inputFindNames();
    ResultView.printResult(ladderMainController.findResult(modelDto, findName),
        modelDto.getPrizes());
    return findName;
  }

  private static boolean isContinue(final String findName) {
    return findName.equals(ALL_NAMES);
  }
}