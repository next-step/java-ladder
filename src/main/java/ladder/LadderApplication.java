package ladder;

import ladder.domain.ladder.Awards;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderResult;
import ladder.ui.InputView;
import ladder.ui.ResultView;

public class LadderApplication {

    public static void main(String[] args) {

        String playersName = InputView.inputPlayersName();
        String namesOfAwards = InputView.inputAwardsName();
        int ladderHeight = InputView.inputLadderHeight();

        Ladder ladder = Ladder.of(playersName, ladderHeight);
        ResultView.printLadder(ladder);

        Awards awards = Awards.of(namesOfAwards);
        ResultView.printAwards(awards);

        LadderResult ladderResult = LadderResult.of(ladder, awards);
        String wantedPlayer;
        do {
            wantedPlayer = InputView.inputWantedPlayerName();
            ResultView.printWantedPlayer(ladderResult, wantedPlayer);
        } while (!"all".equals(wantedPlayer));

        ResultView.printAllPlayer(ladderResult.getResults());

    }

}
