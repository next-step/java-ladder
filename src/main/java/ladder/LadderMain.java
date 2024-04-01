package ladder;

import ladder.domain.GameResult;
import ladder.domain.Gamer;
import ladder.domain.LadderGame;
import ladder.view.DrawView;
import ladder.view.InputView;

import java.util.List;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String inputText = inputView.getParticipants();
        String rawResults = inputView.getResults();
        int height = inputView.getLadderHeight();

        LadderGame ladderGame = new LadderGame(height, inputText);
        GameResult results = new GameResult(rawResults);
        List<Gamer> gamers = ladderGame.doStart();

        DrawView drawView = new DrawView();
        drawView.drawLadder(ladderGame, results);
        drawView.drawGameResult(gamers);
    }
}
