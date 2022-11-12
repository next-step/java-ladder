package nextstep.ladder;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Name;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderApplication {

    public static void main(String[] args) {
        List<Name> names = InputView.readParticipantNames();
        int height = InputView.readLadderHeight();

        Ladder ladder = new Ladder(height, names.size());
        ladder.generateLines();
        LadderGame ladderGame = new LadderGame(names, ladder);

        ResultView.printLadderGame(ladderGame);
    }

}
