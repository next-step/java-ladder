package ladder;

import ladder.domain.LadderGame;
import ladder.domain.Line;
import ladder.domain.Players;
import ladder.domain.RandomDecision;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderMain {
    private static final String INPUT_NAMES_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요";
    private static final String INPUT_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";

    public static void main(String[] args) {
        OutputView.printMsg(INPUT_NAMES_MSG);
        Players players = new Players(InputView.inputPlayers());

        OutputView.printMsg(INPUT_HEIGHT_MSG);
        int height = InputView.inputHeight();

        LadderGame ladderGame = new LadderGame(height, players.size());

        OutputView.print(players.getPlayerNames());
        OutputView.println(ladderGame.getShapeOfLadderAsList());
    }
}
