package ladderGame;

import ladderGame.domain.*;
import ladderGame.dto.GameInformation;
import ladderGame.dto.LadderGameResult;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {

        Players players = InputView.aksPlayers();
        int height = InputView.askLadderHeight();
        LadderResults ladderResults = InputView.askLadderResult();

        Ladder ladder = Ladder.of(players.size(), height);
        GameInformation gameInformation = GameInformation.of(players, ladderResults);

        ResultView.drawLadderAndPlayer(ladder, gameInformation);

        LadderGame game = LadderGame.of(ladder, gameInformation);
        LadderGameResult ladderGameResult = game.run();

        InputView.askResult()
                .filter(playerName -> !playerName.equals("all"))
                .map(playerName -> ResultView.printOne(ladderGameResult.getResultSetByName(playerName)))
                .orElseGet(() -> ResultView.printAll(ladderGameResult.getLadderResult()));
    }
}
