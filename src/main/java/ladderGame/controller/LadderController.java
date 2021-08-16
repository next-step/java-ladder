package ladderGame.controller;

import ladderGame.dto.PlayersDto;
import ladderGame.model.Lines;
import ladderGame.model.Players;
import ladderGame.service.CreatePlayer;
import ladderGame.view.InputView;
import ladderGame.view.PrintView;

public class LadderController {

  private static final String MSG_INSERT_PLAYER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
  public static final String MSG_INSERT_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

  public static void main(String[] args) {

    Players players = new Players(CreatePlayer.createUser(InputView.inputUserNamesWithMessage(
        MSG_INSERT_PLAYER_NAMES)));

    Lines lines = new Lines(InputView.inputLadderHeightWithMessage(MSG_INSERT_HEIGHT), players.findPlayersCount());

    PrintView.printUsersName(PlayersDto.of(players));
    PrintView.createLadderView(lines);
  }
}