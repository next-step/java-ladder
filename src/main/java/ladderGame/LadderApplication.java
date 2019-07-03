package ladderGame;

import ladderGame.domain.Ladder;
import ladderGame.domain.LadderResults;
import ladderGame.domain.Players;
import ladderGame.dto.LadderGameResult;
import ladderGame.util.LadderResultMapper;
import ladderGame.view.InputView;
import ladderGame.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {

        Players players = InputView.aksPlayers();
        int height = InputView.askLadderHeight();
        LadderResults ladderResults = InputView.askLadderResult();

        Ladder ladder = Ladder.of(players.size(), height);

        ResultView.drawLadderAndPlayer(players, ladder, ladderResults);

        players.playGame(ladder);

        LadderGameResult ladderGameResult = LadderResultMapper.map(players, ladderResults);

        InputView.askResult()
                .filter(playerName -> !playerName.equals("all"))
                .map(playerName -> ResultView.printOne(ladderGameResult.getResultSetByName(playerName)))
                .orElseGet(() -> ResultView.printAll(ladderGameResult.getLadderResult()));
    }
}
