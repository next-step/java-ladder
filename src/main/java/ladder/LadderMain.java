package ladder;

import ladder.domain.LadderGame;
import ladder.domain.result.Records;
import ladder.domain.participants.Name;
import ladder.domain.participants.Participants;
import ladder.domain.result.GameResult;
import ladder.view.DrawView;
import ladder.view.InputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String inputText = inputView.getParticipants();
        String rawResults = inputView.getResults();
        int height = inputView.getLadderHeight();

        LadderGame ladderGame = new LadderGame(height, inputText);
        GameResult results = new GameResult(rawResults);

        Participants participants = ladderGame.doStart();

        DrawView drawView = new DrawView();
        drawView.drawLadder(ladderGame, results);

        Name targetName = inputView.getGamerName();

        Records gameRecords = results.recordResult(participants);
        drawView.drawGameRecords(targetName, gameRecords);
    }
}
