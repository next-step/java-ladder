package ladder;

import ladder.domain.ladders.LadderGame;
import ladder.domain.ladders.RandomPointPredicate;
import ladder.domain.result.GameRecords;
import ladder.domain.participants.Name;
import ladder.domain.participants.Participants;
import ladder.view.DrawView;
import ladder.view.InputView;

public class LadderMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        String participantsText = inputView.getParticipants();
        String rewardsText = inputView.getResults();
        int height = inputView.getLadderHeight();

        LadderGame ladderGame = new LadderGame(height, rewardsText, new RandomPointPredicate());
        Participants participants = new Participants(participantsText);
        GameRecords gameRecords = participants.startGame(ladderGame);

        DrawView drawView = new DrawView();
        drawView.drawLadder(ladderGame, participants);

        Name targetName = inputView.getGamerName();
        drawView.drawGameRecords(targetName, gameRecords);
    }
}
